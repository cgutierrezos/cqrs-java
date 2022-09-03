/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package querybus;

import com.cg.cqrs.queryBus.infra.queryBuses.localQueryBus.LocalQueryBus;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import query.ExceptionTestQueryAsker;
import query.TestQuery;
import query.TestQueryAsker;
import query.TestQueryBuilder;
import query.TestQueryChecker;
import query.TestQueryResponse;

/**
 *
 * @author cristian b
 */
public class LocalQueryBusTest {
    
    private final Faker faker;
    private final TestQueryBuilder builder;
    
    public LocalQueryBusTest() {
        this.faker = new Faker();
        this.builder = new TestQueryBuilder(this.faker);
        
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void ask() throws Exception {
        
        LocalQueryBus queryBus = new LocalQueryBus();
        
        TestQuery query = this.builder.build();
        
        TestQueryChecker checker = new TestQueryChecker(query);
        
        queryBus.subscribe(new TestQueryAsker(checker));
        
        TestQueryResponse response = (TestQueryResponse) queryBus.ask(query);
        
        assertTrue(checker.isChecked());
        assertTrue(response.toString().contains(query.toString()));
        
    }
    
    
    @Test
    public void askThrows() throws Exception {
        
        LocalQueryBus queryBus = new LocalQueryBus();
        
        TestQuery query = this.builder.build();
        
        TestQueryChecker checker = new TestQueryChecker(query);
        
        queryBus.subscribe(new ExceptionTestQueryAsker(checker));
        
        Exception e = assertThrows(Exception.class, () -> {
              queryBus.ask(query);
        });
        
        assertTrue(checker.isChecked());
        assertEquals(e.getClass(), Exception.class);
        
    }
    
    
    
    
}
