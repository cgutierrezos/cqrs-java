/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package querybus;

import com.cg.cqrs.querybus.domain.QueryBus;
import com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.NotifyQueryBus;
import com.cg.cqrs.querybus.infra.querybuses.localquerybus.LocalQueryBus;
import com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.exceptionquerynotifiers.FakeExceptionQueryNotifier;
import com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.querynotifiers.FakeQueryNotifier;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import query.TestQuery;
import query.TestQueryAsker;
import query.TestQueryResponse;
import static org.junit.jupiter.api.Assertions.*;
import query.ExceptionTestQueryAsker;
import query.TestQueryAskerException;
import query.TestQueryBuilder;
import query.TestQueryChecker;

/**
 *
 * @author cristian b
 */
public class NotifyQueryBusTest {
    
    private final Faker faker;
    private final TestQueryBuilder builder;
    
    public NotifyQueryBusTest() {
        this.faker = new Faker();
        this.builder = new TestQueryBuilder(this.faker);
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void notifyQuery() throws Exception {
        
        FakeQueryNotifier notifier = new FakeQueryNotifier();
        
        QueryBus queryBus = new NotifyQueryBus(
                new LocalQueryBus(),  
                notifier
        );
        
        TestQuery query = this.builder.build();
        
        TestQueryChecker checker =  new TestQueryChecker(query);
        
        queryBus.subscribe(new TestQueryAsker(checker));
        
        TestQueryResponse response = (TestQueryResponse) queryBus.ask(query);
        
        assertTrue(checker.isChecked());
        assertTrue(response.toString().contains(query.toString()));
        assertTrue(notifier.isQueryNotified(query));
    }
    
    
    @Test
    public void notifyQueryException() throws Exception {
        
        FakeExceptionQueryNotifier exceptionNotifier = new FakeExceptionQueryNotifier();
        
        QueryBus queryBus = new NotifyQueryBus(
                new LocalQueryBus(),  
                exceptionNotifier
        );
        
        TestQuery query = this.builder.build();
        
        TestQueryChecker checker =  new TestQueryChecker(query);
        
        queryBus.subscribe(new ExceptionTestQueryAsker(checker));
        
        TestQueryAskerException e = assertThrows(TestQueryAskerException.class, () -> {
              queryBus.ask(query);
        });
        
        assertTrue(checker.isChecked());
        assertEquals(e.getClass(), TestQueryAskerException.class);
        assertTrue(exceptionNotifier.isQueryNotified(query));
        
    }
    
}
