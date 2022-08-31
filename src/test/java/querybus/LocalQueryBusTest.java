/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package querybus;

import com.cg.cqrs.query.domain.QueryHeader;
import com.cg.cqrs.queryBus.domain.QueryBus;
import com.cg.cqrs.queryBus.infra.queryBuses.localQueryBus.LocalQueryBus;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import query.TestQuery;
import query.TestQueryAsker;
import query.TestQueryMessage;
import query.TestQueryResponse;

/**
 *
 * @author cristian b
 */
public class LocalQueryBusTest {
    
    private final Faker faker;
    
    public LocalQueryBusTest() {
        this.faker = new Faker();
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
        
    }
    
    
    @Test
    public void askThrows() throws Exception {
        
        QueryBus queryBus = new LocalQueryBus();
        
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
        
    }
    
}
