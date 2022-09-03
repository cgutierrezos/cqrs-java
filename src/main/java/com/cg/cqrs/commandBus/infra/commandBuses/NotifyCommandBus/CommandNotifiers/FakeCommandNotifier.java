/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandBus.infra.commandBuses.NotifyCommandBus.CommandNotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.commandCollection.CommandCollection;
import com.cg.cqrs.command.domain.commandCollection.CommandFilter;
import com.cg.cqrs.commandBus.domain.CommandNotifier;

/**
 *
 * @author cristian b
 */
public class FakeCommandNotifier implements CommandNotifier{

    private final CommandCollection comands;

    public FakeCommandNotifier() {
        this.comands = new CommandCollection();
    }
    
    
    
    @Override
    public void notify(Command command) {
        this.comands.add(command);
    }
    
    public int size() {
        return this.comands.size();
    }
    
    public boolean isCommandNotified(Command command){
        CommandFilter filter = this.comands.filter();
        
        return filter.findOneByID(command.commandId()) != null;
    }
    
    
    public int notificationsByCommandClass(Class<Command> commandClass){
        CommandFilter filter = this.comands.filter();
        
        CommandCollection commands = filter.findManyByClass(commandClass);
        
        return commands.size();
    }
    
    
    
    
    
}
