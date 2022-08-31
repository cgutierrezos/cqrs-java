/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandBus.infra.commandBuses.localCommandBus;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;
import com.cg.cqrs.command.domain.commandHandlerCollection.CommandHandlerCollection;
import com.cg.cqrs.command.domain.commandHandlerCollection.CommandHandlerFilter;
import com.cg.cqrs.commandBus.domain.CommandBus;

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
    public void handle(Command command) throws Exception {
        CommandHandler handler = this.findByCommand(command);
        
        if(handler == null){
            throw new Exception("No CommandHandler found");
        }
        
        handler.handle(command);
    }
    
    
    private CommandHandler findByCommand(Command command){
        
        CommandHandlerFilter filter = this.handlers.filter();
        
        return filter.findOneByCommandClass(command.getClass());
        
    }
    
}
