/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.query.domain;

/**
 *
 * @author cristian b
 * @param <Q>
 */
public interface QueryAsker<Q extends Query> {
    
    public String subscribedTo();
    
    public QueryResponse ask(Q query);
}
