/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package commandBus;

import com.cg.cqrs.commandBus.infra.commandBuses.localCommandBus.LocalCommandBus;
import com.github.javafaker.Faker;
import command.ExceptionTestCommandHandler;
import command.TestCommand;
import command.TestCommandBuilder;
import command.TestCommandChecker;
import command.TestCommandHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import query.TestQueryBuilder;

/**
 *
 * @author cristian b
 */
public class LocalCommandBusTest {
    
    private final Faker faker;
    private final TestCommandBuilder builder;
    
    public LocalCommandBusTest() {
        this.faker = new Faker();
        this.builder = new TestCommandBuilder(this.faker);
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void handle() throws Exception{
        LocalCommandBus commandBus = new LocalCommandBus();
     
        TestCommand command = this.builder.build();
        
        TestCommandChecker checker = new TestCommandChecker(command);
        
        commandBus.subscibe(new TestCommandHandler(checker));
        
        commandBus.handle(command);
        
        assertTrue(checker.isChecked());
        
    }
    
    @Test
    public void handleException() throws Exception{
        LocalCommandBus commandBus = new LocalCommandBus();
     
        TestCommand command = this.builder.build();
        
        TestCommandChecker checker = new TestCommandChecker(command);
        
        commandBus.subscibe(new ExceptionTestCommandHandler(checker));
        
        Exception e = assertThrows(Exception.class, () -> {
            commandBus.handle(command);
        });
        
        assertTrue(checker.isChecked());
        assertTrue(e.getClass().equals(Exception.class));

    }
    
    
    
}
