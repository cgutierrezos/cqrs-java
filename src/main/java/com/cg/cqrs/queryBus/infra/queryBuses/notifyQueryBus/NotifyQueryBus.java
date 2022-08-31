/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus;

import com.cg.cqrs.queryBus.domain.ExceptionQueryNotifier;
import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import com.cg.cqrs.query.domain.QueryResponse;
import com.cg.cqrs.queryBus.domain.QueryBus;
import com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.exceptionQueryNotifiers.NoneExceptionQueryNotifier;
import com.cg.cqrs.queryBus.domain.QueryNotifier;
import com.cg.cqrs.queryBus.infra.queryBuses.notifyQueryBus.queryNotifiers.NoneQueryNotifier;

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
    public <T extends Query> QueryResponse<T> ask(T query) throws Exception {
        try {

            QueryResponse<T> response = this.queryBus.ask(query);
            this.notifier.notify(query, response);
            return response;

        } catch (Exception e) {

            this.exceptionNotifier.notify(e, query);
            throw e;

        }
    }

}
