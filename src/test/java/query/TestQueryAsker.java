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

    private final TestQueryChecker checker;
    
    public TestQueryAsker(TestQueryChecker checker) {
        this.checker = checker;
    }

    @Override
    public String subscribedTo() {
        return TestQuery.class.getSimpleName();
    }

    @Override
    public QueryResponse ask(TestQuery query) {
        this.checker.check(query);
        return new TestQueryResponse(query);
    }
    
    
    
    
    
}
