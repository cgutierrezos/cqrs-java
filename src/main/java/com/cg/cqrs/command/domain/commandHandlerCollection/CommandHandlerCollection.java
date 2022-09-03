/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandHandlerCollection;

import com.cg.cqrs.command.domain.CommandHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class CommandHandlerCollection<T extends CommandHandler> {
    
    private final Collection<T> handlers;

    public CommandHandlerCollection() {
        this.handlers = new ArrayList<>();
    }
    
    public void add(T handler) {
        this.handlers.add(handler);
    }
    
    public Iterator<T> iterator() {
        return this.handlers.iterator();
    }
    
    public CommandHandlerFilter<T> filter() {
        return new CommandHandlerFilter(this.handlers);
    }

}
