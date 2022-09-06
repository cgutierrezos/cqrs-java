/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.querybus.infra.querybuses.notifyquerybus;

import com.cg.cqrs.querybus.domain.ExceptionQueryNotifier;
import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.querybus.domain.QueryBus;
import com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.exceptionquerynotifiers.NoneExceptionQueryNotifier;
import com.cg.cqrs.querybus.domain.QueryNotifier;
import com.cg.cqrs.querybus.infra.querybuses.notifyquerybus.querynotifiers.NoneQueryNotifier;

/**
 *
 * @author cristian b
 */
public class NotifyQueryBus implements QueryBus {

    private final QueryBus queryBus;
    private final ExceptionQueryNotifier exceptionNotifier;
    private final QueryNotifier notifier;

    public NotifyQueryBus(QueryBus queryBus, QueryNotifier notifier, ExceptionQueryNotifier exceptionNotifier) {
        this.queryBus = queryBus;
        this.notifier = notifier;
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyQueryBus(QueryBus queryBus, QueryNotifier notifier) {
        this.queryBus = queryBus;
        this.notifier = notifier;
        this.exceptionNotifier = new NoneExceptionQueryNotifier();
    }

    public NotifyQueryBus(QueryBus queryBus, ExceptionQueryNotifier exceptionNotifier) {
        this.queryBus = queryBus;
        this.notifier = new NoneQueryNotifier();
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyQueryBus(QueryBus queryBus) {
        this.queryBus = queryBus;
        this.notifier = new NoneQueryNotifier();
        this.exceptionNotifier = new NoneExceptionQueryNotifier();
    }

    @Override
    public void subscribe(QueryAsker asker) {
        this.queryBus.subscribe(asker);
    }

    @Override
    public QueryResponse ask(Query query) {
        try {

            QueryResponse response = this.queryBus.ask(query);
            this.notifier.notify(query, response);
            return response;

        } catch (Exception e) {

            this.exceptionNotifier.notify(e, query);
            throw e;

        }
    }

}
