/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain;

import java.util.Date;

/**
 *
 * @author cristian b
 */
public class QueryHeader {
    
    private final String id;
    private final Date timeStamp;
    
    public QueryHeader(String id, Date createdAt) {
        this.id = id;
        this.timeStamp = createdAt;
    }
    
    public QueryHeader(String id) {
        this.id = id;
        this.timeStamp = new Date();
    }

    public String id() {
        return id;
    }

    public Date timeStamp() {
        return timeStamp;
    }
    
    
}
