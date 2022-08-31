/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.queryBus.domain;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryResponse;

/**
 *
 * @author cristian b
 */
public interface QueryNotifier {
    
    /**
     *
     * @param <T>
     * @param query
     * @param response
     */
    public <T extends Query>void notify(T query, QueryResponse<T> response);
    
}
