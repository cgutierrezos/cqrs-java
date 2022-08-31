/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

import com.cg.cqrs.query.domain.QueryResponse;

/**
 *
 * @author cristian b
 */
public class TestQueryResponse implements QueryResponse<TestQuery>{
    
    private final TestQuery query;

    public TestQueryResponse(TestQuery query) {
        this.query = query;
    }
    
    @Override
    public String toString() {
        return String.format("QueryResponse { %s }", this.query.toString());
    }
}
