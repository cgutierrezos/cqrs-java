/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.querynotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.querycollection.QueryCollection;
import com.cg.cqrs.query.domain.querycollection.QueryFilter;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.querybus.domain.QueryNotifier;

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
    public void notify(Query query, QueryResponse response) {
        this.queries.add(query);
    }
    
    public int notifications(){
        return this.queries.size();
    }
    
    public boolean isQueryNotified(Query query) {
        
        QueryFilter filter = this.queries.filter();
        
        return filter.findOneByID(query.queryID()) != null;
    }
    
    public int notificationsByQueryClass(Class<Query> queryClass){
        QueryFilter filter = this.queries.filter();
        
        QueryCollection filtered = filter.findManyByClass(queryClass);
        
        return filtered.size();
    }
    
}
