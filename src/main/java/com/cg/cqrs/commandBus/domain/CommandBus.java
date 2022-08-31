/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandBus.domain;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;

/**
 *
 * @author cristian b
 */
public interface CommandBus {
    
    /**
     *
     * @param handler
     */
    public void subscibe(CommandHandler handler);
    
    /**
     *
     * @param command
     * @throws java.lang.Exception
     */
    public void handle(Command command) throws Exception;
}
