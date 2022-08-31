/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package querybus;

import com.cg.cqrs.query.domain.QueryHeader;
import com.cg.cqrs.queryBus.domain.QueryBus;
import com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.NotifyQueryBus;
import com.cg.cqrs.queryBus.infra.queryBuses.localQueryBus.LocalQueryBus;
import com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.exceptionQueryNotifiers.FakeExceptionQueryNotifier;
import com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.queryNotifiers.FakeQueryNotifier;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import query.TestQuery;
import query.TestQueryAsker;
import query.TestQueryResponse;
import static org.junit.jupiter.api.Assertions.*;
import query.TestQueryMessage;

/**
 *
 * @author cristian b
 */
public class NotifyQueryBusTest {
    
    private final Faker faker;
    
    public NotifyQueryBusTest() {
        
        this.faker = new Faker();
        
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
        
        queryBus.subscribe(new TestQueryAsker());
        
        TestQuery query = new TestQuery(
                new TestQueryMessage(
                        this.faker.internet().uuid(), 
                        this.faker.name().name()
                ),
                new QueryHeader(this.faker.internet().uuid())
        );
        
        TestQueryResponse response = (TestQueryResponse) queryBus.ask(query);
        
        assertTrue(response.toString().contains(query.toString()));
        assertTrue(notifier.wasQueryNotified(query));
    }
    
    
    @Test
    public void notifyQueryException() throws Exception {
        
        FakeExceptionQueryNotifier exceptionNotifier = new FakeExceptionQueryNotifier();
        
        QueryBus queryBus = new NotifyQueryBus(
                new LocalQueryBus(),  
                exceptionNotifier
        );
        
        TestQuery query = new TestQuery(
                new TestQueryMessage(
                        this.faker.internet().uuid(), 
                        this.faker.name().name()
                ),
                new QueryHeader(this.faker.internet().uuid())
        );
        
        Exception e = assertThrows(Exception.class, () -> {
              queryBus.ask(query);
        });
        
        assertEquals(e.getClass(), Exception.class);
        assertTrue(exceptionNotifier.wasQueryNotified(query));
        
    }
    
}
