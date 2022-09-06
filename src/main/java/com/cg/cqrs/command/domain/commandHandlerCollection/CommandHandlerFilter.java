/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandhandlercollection;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;
import java.util.Collection;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class CommandHandlerFilter<T extends CommandHandler> {
    
    public interface FilterCallback<T extends CommandHandler> {
        public boolean filter(T handler);
    }
    
    private final Collection<T> handlers;

    public CommandHandlerFilter(Collection<T> handlers) {
        this.handlers = handlers;
    }
    
    public T findOneByCommandClass(Class<Command> commandClass) {
        return this.findOne((T handler) -> 
                commandClass.getSimpleName().equals(handler.subscribedTo())
        );
    }
    
    public T findOne(FilterCallback<T> callback) {
        
        for (T handler : this.handlers) {
            if(callback.filter(handler)){
                return handler;
            }
        }
        
        return null;
    }
    
    
}
