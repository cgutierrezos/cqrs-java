/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.localquerybus;

import com.cg.cqrs.query.domain.queryaskercollection.QueryAskerCollection;
import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.query.domain.queryaskercollection.QueryAskerFilter;
import com.cg.cqrs.querybus.domain.QueryBus;

/**
 *
 * @author cristian b
 */
public class LocalQueryBus implements QueryBus {

    private final QueryAskerCollection askers;

    public LocalQueryBus () {
        this.askers = new QueryAskerCollection();
    }

    /**
     *
     * @param asker
     */
    @Override
    public void subscribe(QueryAsker asker){
        this.askers.add(asker);
    }
    
    /**
     *
     * @param query
     * @return
     */
    @Override
    public QueryResponse ask(Query query) {
        QueryAsker asker = this.findAskerByQuery(query);
        
        if(asker == null){
            throw new QueryAskerNotFoundException(query);
        }
        
        return asker.ask(query);
        
    }
    
    private QueryAsker findAskerByQuery(Query query){
        
        QueryAskerFilter filter = this.askers.filter();
        
        return filter.findOneByQueryClass(query.getClass());
    }

}
