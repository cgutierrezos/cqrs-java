/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.queryNotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.queryCollection.QueryCollection;
import com.cg.cqrs.query.domain.queryCollection.QueryFilter;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.queryBus.domain.QueryNotifier;

/**
 *
 * @author cristian b
 */
public class FakeQueryNotifier implements QueryNotifier {

    private final QueryCollection queries;

    public FakeQueryNotifier() {
        this.queries = new QueryCollection();
    }
    
    @Override
    public <T extends Query>void notify(T query, QueryResponse<T> response) {
        this.queries.add(query);
    }
    
    public int notifications(){
        return this.queries.size();
    }
    
    public boolean wasQueryNotified(Query query) {
        
        QueryFilter filter = this.queries.filter();
        
        return filter.findOneByID(query.queryID()) != null;
    }
    
    public int notificationsByQueryClass(Class<Query> queryClass){
        QueryFilter filter = this.queries.filter();
        
        QueryCollection filtered = filter.findManyByClass(queryClass);
        
        return filtered.size();
    }
    
}
