/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.localcommandbus;

import com.cg.cqrs.command.domain.Command;

/**
 *
 * @author cristian b
 */
public final class CommandHandlerNotFoundException extends RuntimeException{

    public CommandHandlerNotFoundException(Command command) {
        super(String.format("CommandHandler not found for Command [ %s ]", command.getClass().getSimpleName()));
    }
    
    
}
