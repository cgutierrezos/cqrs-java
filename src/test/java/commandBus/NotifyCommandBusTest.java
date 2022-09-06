/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package commandBus;

import com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.commandnotifiers.FakeCommandNotifier;
import com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.exceptioncommandnotifiers.ExceptionFakeCommandNotifier;
import com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.NotifyCommandBus;
import com.cg.cqrs.commandbus.infra.commandbuses.localcommandbus.LocalCommandBus;
import com.github.javafaker.Faker;
import command.ExceptionTestCommandHandler;
import command.TestCommand;
import command.TestCommandBuilder;
import command.TestCommandChecker;
import command.TestCommandHandler;
import command.TestCommandHandlerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author cristian b
 */
public class NotifyCommandBusTest {
    
    private final Faker faker;
    private final TestCommandBuilder builder;
    
    public NotifyCommandBusTest() {
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
        
        FakeCommandNotifier notifier = new FakeCommandNotifier();
        
        NotifyCommandBus commandBus = new NotifyCommandBus(
                new LocalCommandBus(),
                notifier
        );
     
        TestCommand command = this.builder.build();
        
        TestCommandChecker checker = new TestCommandChecker(command);
        
        commandBus.subscibe(new TestCommandHandler(checker));
        
        commandBus.handle(command);
        
        assertTrue(checker.isChecked());
        assertTrue(notifier.isCommandNotified(command));
        
    }
    
    @Test
    public void handleException() throws Exception{
             
        ExceptionFakeCommandNotifier exceptionNotifier = new ExceptionFakeCommandNotifier();
        
        NotifyCommandBus commandBus = new NotifyCommandBus(
                new LocalCommandBus(),
                exceptionNotifier
        );
        
        TestCommand command = this.builder.build();
        
        TestCommandChecker checker = new TestCommandChecker(command);
        
        commandBus.subscibe(new ExceptionTestCommandHandler(checker));
        
        TestCommandHandlerException e = assertThrows(TestCommandHandlerException.class, () -> {
            commandBus.handle(command);
        });
        
        assertTrue(checker.isChecked());
        assertTrue(e.getClass().equals(TestCommandHandlerException.class));
        assertTrue(exceptionNotifier.isCommandNotified(command));

    }
    
    
    
}
