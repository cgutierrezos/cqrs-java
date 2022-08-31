/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.commandBus.domain;

import com.cg.cqrs.command.domain.Command;

/**
 *
 * @author cristian b
 */
public interface ExceptionCommandNotifier {
    
    /**
     *
     * @param e
     * @param command
     */
    public void notify(Exception e, Command command);
}
