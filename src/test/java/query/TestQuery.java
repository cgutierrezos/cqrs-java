/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryHeader;

/**
 *
 * @author cristian b
 */
public class TestQuery extends Query {
    
    private final TestQueryMessage message;

    public TestQuery(TestQueryMessage message, QueryHeader header) {
        super(header);
        this.message = message;
    }

    public String id(){
        return this.message.id();
    }
    
    public String name(){
        return this.message.name();
    }

    @Override
    public String toString() {
        return String.format("TestQuery { queryId: '%s', queryTimeStamp: '%s', id: '%s', name: '%s' }", this.queryID(), this.queryTimeStamp(), this.id(), this.name());
    }

    
    
    
    
    
}
