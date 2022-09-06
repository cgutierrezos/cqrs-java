/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.querynotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.querybus.domain.QueryNotifier;

/**
 *
 * @author cristian b
 */
public class NoneQueryNotifier implements QueryNotifier{

    @Override
    public  void notify(Query query, QueryResponse response) {
       // NONE QUERY NOTIFICATION
    }

    
}
