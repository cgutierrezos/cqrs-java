/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.exceptionquerynotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.querybus.domain.ExceptionQueryNotifier;
import com.cg.cqrs.query.domain.querycollection.QueryCollection;
import com.cg.cqrs.query.domain.querycollection.QueryFilter;

/**
 *
 * @author cristian b
 */
public class FakeExceptionQueryNotifier implements ExceptionQueryNotifier {

    private final QueryCollection queries;

    public FakeExceptionQueryNotifier() {
        this.queries = new QueryCollection();
    }
    
    @Override
    public void notify(Exception e, Query query) {
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
