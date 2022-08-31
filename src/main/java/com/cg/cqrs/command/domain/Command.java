/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.command.domain;

import java.util.Date;

/**
 *
 * @author cristian b
 */
public abstract class Command {
    
    private final CommandHeader header;

    /**
     *
     * @param header
     */
    public Command(CommandHeader header) {
        this.header = header;
    }
    
    /**
     *
     * @return
     */
    public String commandId() {
        return this.header.id();
    }
    
    /**
     *
     * @return
     */
    public Date commandTimeStamp() {
        return this.header.timeStamp();
    }
    
    
}
