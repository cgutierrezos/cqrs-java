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
public interface CommandNotifier {
    
    /**
     *
     * @param command
     */
    public void notify(Command command);
}
