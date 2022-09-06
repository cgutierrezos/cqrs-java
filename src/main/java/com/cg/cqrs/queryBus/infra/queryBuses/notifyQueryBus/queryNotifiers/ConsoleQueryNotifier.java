/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.querynotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.querybus.domain.QueryNotifier;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cristian b
 */
public class ConsoleQueryNotifier implements QueryNotifier{

    private final Logger logger;

    public ConsoleQueryNotifier(Logger logger) {
        this.logger = logger;
    }
    
    
    
    @Override
    public <T extends Query> void notify(T query, QueryResponse response) {
        this.logger.debug(String.format("Query: %s", query));
        this.logger.debug(String.format("Response: %s", response));
    }
}
