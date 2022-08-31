/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandHandlerCollection;

import com.cg.cqrs.command.domain.CommandHandler;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author cristian b
 */
public class CommandHandlerCollection {
    
    public interface ForEachCallback {
        public void next(CommandHandler handler);
    }
    
    private final ArrayList<CommandHandler> handlers;

    public CommandHandlerCollection() {
        this.handlers = new ArrayList<>();
    }
    
    public void add(CommandHandler handler) {
        this.handlers.add(handler);
    }
    
    public Iterator<CommandHandler> iterator() {
        return this.handlers.iterator();
    }
    
    public CommandHandlerFilter filter() {
        return new CommandHandlerFilter(this.handlers);
    }
    
    public void forEach(ForEachCallback callback) {
        for (CommandHandler handler : this.handlers) {
            callback.next(handler);
        }
    }
}
