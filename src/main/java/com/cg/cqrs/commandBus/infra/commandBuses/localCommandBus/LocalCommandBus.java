/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.localcommandbus;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;
import com.cg.cqrs.command.domain.commandhandlercollection.CommandHandlerCollection;
import com.cg.cqrs.command.domain.commandhandlercollection.CommandHandlerFilter;
import com.cg.cqrs.commandbus.domain.CommandBus;

/**
 *
 * @author cristian b
 */
public class LocalCommandBus implements CommandBus{

    private final CommandHandlerCollection handlers;

    public LocalCommandBus() {
        this.handlers = new CommandHandlerCollection();
    }

    /**
     *
     * @param handler
     */
    @Override
    public void subscibe(CommandHandler handler) {
        this.handlers.add(handler);
    }

    /**
     *
     * @param command
     */
    @Override
    public void handle(Command command) {
        CommandHandler handler = this.findByCommand(command);
        
        if(handler == null){
            throw new CommandHandlerNotFoundException(command);
        }
        
        handler.handle(command);
    }
    
    
    private CommandHandler findByCommand(Command command){
        
        CommandHandlerFilter filter = this.handlers.filter();
        
        return filter.findOneByCommandClass(command.getClass());
        
    }
    
}
