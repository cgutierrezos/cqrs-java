/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.querybus.domain;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;

/**
 *
 * @author cristian b
 */
public interface QueryBus {
    
    /**
     *
     * @param asker
     */
    public void subscribe(QueryAsker asker);
    
    /**
     *
     * @param query
     * @return
     */
    public QueryResponse ask(Query query);
}
