/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHandler;
import com.cg.cqrs.commandbus.domain.CommandBus;
import com.cg.cqrs.commandbus.domain.CommandNotifier;
import com.cg.cqrs.commandbus.domain.ExceptionCommandNotifier;
import com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.commandnotifiers.NoneCommandNotifier;
import com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.exceptioncommandnotifiers.NoneExceptionCommandNotifier;

/**
 *
 * @author cristian b
 */
public class NotifyCommandBus implements CommandBus {
    
    private final CommandBus commandBus;
    private final CommandNotifier notifier;
    private final ExceptionCommandNotifier exceptionNotifier;

    public NotifyCommandBus(CommandBus commandBus, CommandNotifier notifier, ExceptionCommandNotifier exceptionNotifier) {
        this.commandBus = commandBus;
        this.notifier = notifier;
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyCommandBus(CommandBus commandBus, CommandNotifier notifier) {
        this.commandBus = commandBus;
        this.notifier = notifier;
        this.exceptionNotifier = new NoneExceptionCommandNotifier();
    }

    public NotifyCommandBus(CommandBus commandBus, ExceptionCommandNotifier exceptionNotifier) {
        this.commandBus = commandBus;
        this.notifier = new NoneCommandNotifier();
        this.exceptionNotifier = exceptionNotifier;
    }

    public NotifyCommandBus(CommandBus commandBus) {
        this.commandBus = commandBus;
        this.notifier = new NoneCommandNotifier();
        this.exceptionNotifier = new NoneExceptionCommandNotifier();
    }
    
    

    @Override
    public void subscibe(CommandHandler handler) {
        this.commandBus.subscibe(handler);
    }

    @Override
    public void handle(Command command) {
        try{
            this.commandBus.handle(command);
            this.notifier.notify(command);
        }catch(Exception e){
            this.exceptionNotifier.notify(e, command);
            throw e;
        }
    }
    
    
    
    
    
    
}
