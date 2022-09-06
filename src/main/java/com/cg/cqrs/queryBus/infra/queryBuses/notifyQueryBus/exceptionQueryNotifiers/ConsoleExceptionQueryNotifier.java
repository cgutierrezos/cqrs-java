/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.exceptionquerynotifiers;

import com.cg.cqrs.querybus.domain.ExceptionQueryNotifier;
import com.cg.cqrs.query.domain.Query;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cristian b
 */
public class ConsoleExceptionQueryNotifier implements ExceptionQueryNotifier {

    private final Logger logger;

    public ConsoleExceptionQueryNotifier(Logger logger) {
        this.logger = logger;
    }
    
    
    
    @Override
    public void notify(Exception e, Query query){
        this.logger.debug(String.format("Exception Caught in query: %s", query));
        this.logger.debug(e.getMessage());
    }
    
}
