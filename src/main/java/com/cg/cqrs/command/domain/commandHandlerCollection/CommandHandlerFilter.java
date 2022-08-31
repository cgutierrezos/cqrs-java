/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandHandlerCollection;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;
import java.util.Collection;

/**
 *
 * @author cristian b
 */
public class CommandHandlerFilter {
    
    public interface FilterCallback {
        public boolean filter(CommandHandler handler);
    }
    
    private final Collection<CommandHandler> handlers;

    public CommandHandlerFilter(Collection<CommandHandler> handlers) {
        this.handlers = handlers;
    }
    
    public <C extends Command>CommandHandler<C> findOneByCommandClass(Class<C> commandClass) {
        return this.findOne((CommandHandler handler) -> {
           return commandClass.getSimpleName().equals(handler.subscribedTo());
        });
    }
    
    public CommandHandler findOne(FilterCallback callback) {
        
        for (CommandHandler handler : this.handlers) {
            if(callback.filter(handler)){
                return handler;
            }
        }
        
        return null;
    }
    
    
}
