/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;

/**
 *
 * @author cristian b
 */
public class TestQueryAsker implements QueryAsker<TestQuery>{

    public TestQueryAsker() {
        
    }

    @Override
    public String subscribedTo() {
        return TestQuery.class.getSimpleName();
    }

    @Override
    public QueryResponse<TestQuery> ask(TestQuery query) throws Exception {
        
        return new TestQueryResponse(query);
    }
    
    
    
    
    
}
