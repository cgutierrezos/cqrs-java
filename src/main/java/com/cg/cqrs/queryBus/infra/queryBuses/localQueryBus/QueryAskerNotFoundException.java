/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.localquerybus;

import com.cg.cqrs.query.domain.Query;

/**
 *
 * @author cristian b
 */
public class QueryAskerNotFoundException extends RuntimeException {

    public QueryAskerNotFoundException(Query query) {
        super(String.format(
                "QueryAsker not found for Query [ %s ]", 
                query.getClass().getSimpleName())
        );
    }
    
    
}
