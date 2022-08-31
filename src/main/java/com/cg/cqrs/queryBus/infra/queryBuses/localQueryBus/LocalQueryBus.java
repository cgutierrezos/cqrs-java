/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.queryBus.infra.queryBuses.localQueryBus;

import com.cg.cqrs.query.domain.queryAskerCollection.QueryAskerCollection;
import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.query.domain.queryAskerCollection.QueryAskerFilter;
import com.cg.cqrs.queryBus.domain.QueryBus;

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
     * @param <T>
     * @param query
     * @return
     * @throws Exception
     */
    @Override
    public <T extends Query>QueryResponse<T> ask(T query) throws Exception {
        QueryAsker<T> asker = this.findAskerByQuery(query);
        
        if(asker == null){
            throw new Exception("Asker not found");
        }
        
        return asker.ask(query);
        
    }
    
    private QueryAsker findAskerByQuery(Query query){
        
        QueryAskerFilter filter = this.askers.filter();
        
        return filter.findOneByQueryClass(query.getClass());
    }

}
