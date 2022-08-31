/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandBus.infra.commandBuses.NotifyCommandBus.ExceptionCommandNotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandBus.domain.ExceptionCommandNotifier;

/**
 *
 * @author cristian b
 */
public class NoneExceptionCommandNotifier implements ExceptionCommandNotifier{

    @Override
    public void notify(Exception e, Command command) {
        
    }
    
}
