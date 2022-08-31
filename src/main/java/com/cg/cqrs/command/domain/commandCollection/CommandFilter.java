/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandCollection;

import com.cg.cqrs.command.domain.Command;
import java.util.Collection;
import java.util.Iterator;



/**
 *
 * @author cristian b
 */
public class CommandFilter {
    
    /**
     *
     */
    public interface filterCallback {
        public boolean filter(Command command);
    }
    
    private final Collection<Command> commands;

    /**
     *
     * @param commands
     */
    public CommandFilter(Collection<Command> commands) {
        this.commands = commands;
    }
    
    /**
     *
     * @param commandClass
     * @return
     */
    public CommandCollection findManyByClass(Class<Command> commandClass){
        
        return this.findMany((Command command) -> {
            return commandClass.equals(command.getClass());
        });
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Command findOneByID(String id) {
        
        return this.findOne((Command command) -> {
            return id.equals(command.commandId());
        });
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public Command findOne(filterCallback callback) {
        Iterator<Command> iterator = this.commands.iterator();
        
        while(iterator.hasNext()){
            Command command = iterator.next();
            
            if(callback.filter(command)){
                return command;
            }
        }
        
        return null;
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public CommandCollection findMany(filterCallback callback) {
        
        CommandCollection filtered = new CommandCollection();
        
        Iterator<Command> iterator = this.commands.iterator();
        while(iterator.hasNext()){
            Command command = iterator.next();
            
            if(callback.filter(command)){
                filtered.add(command);
            }
        }
        
        return filtered;
    }
}
