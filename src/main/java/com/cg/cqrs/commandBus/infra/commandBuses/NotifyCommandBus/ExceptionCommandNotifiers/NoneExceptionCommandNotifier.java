/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.exceptioncommandnotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandbus.domain.ExceptionCommandNotifier;

/**
 *
 * @author cristian b
 */
public class NoneExceptionCommandNotifier implements ExceptionCommandNotifier{

    @Override
    public void notify(Exception e, Command command) {
        // NONE EXCEPTION NOTIFICATION
    }
    
}
