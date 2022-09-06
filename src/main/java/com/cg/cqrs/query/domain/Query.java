/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.query.domain;

import java.util.Date;

/**
 *
 * @author cristian b
 */
public abstract class Query {    
    
    private final QueryHeader header;

    protected Query(QueryHeader header) {
        this.header = header;
    }
    
    
    public String queryID() {
        return this.header.id();
    }
    
    public Date queryTimeStamp() {
        return this.header.timeStamp();
    }
    
}
