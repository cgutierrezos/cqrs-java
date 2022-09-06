/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.command.domain;

/**
 *
 * @author cristian b
 * @param <C>
 */
public interface CommandHandler<C extends Command> {
    
    public String subscribedTo();
    
    /**
     *
     * @param command
     */
    public void handle(C command);
}
