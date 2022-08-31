/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.exceptionQueryNotifiers;

import com.cg.cqrs.queryBus.domain.ExceptionQueryNotifier;
import com.cg.cqrs.query.domain.Query;

/**
 *
 * @author cristian b
 */
public class ConsoleExceptionQueryNotifier implements ExceptionQueryNotifier {

    @Override
    public void notify(Exception e, Query query){
        System.err.println(String.format("Exception Caught in query: %s", query));
        System.out.println(e.getMessage());
    }
    
}
