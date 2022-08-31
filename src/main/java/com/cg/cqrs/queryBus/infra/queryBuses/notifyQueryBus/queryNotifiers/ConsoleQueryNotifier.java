/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.queryNotifiers;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.queryBus.domain.QueryNotifier;

/**
 *
 * @author cristian b
 */
public class ConsoleQueryNotifier implements QueryNotifier{

    @Override
    public <T extends Query> void notify(T query, QueryResponse<T> response) {
        System.out.println(String.format("Query: %s", query));
        System.out.println(String.format("Response: %s", response));
    }
}
