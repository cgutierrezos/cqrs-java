/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain;

import java.util.Date;

/**
 *
 * @author cristian b
 */
public class CommandHeader {
    
    private final String id;
    private final Date timeStamp;

    /**
     *
     * @param id
     * @param timeStamp
     */
    public CommandHeader(String id, Date timeStamp) {
        this.id = id;
        this.timeStamp = timeStamp;
    }

    /**
     *
     * @return
     */
    public String id() {
        return this.id;
    }

    /**
     *
     * @return
     */
    public Date timeStamp() {
        return this.timeStamp;
    }
    
    
    
}
