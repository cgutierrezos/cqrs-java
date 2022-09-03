/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandBus.infra.commandBuses.NotifyCommandBus.CommandNotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandBus.domain.CommandNotifier;

/**
 *
 * @author cristian b
 */
public class ConsoleCommandNotifier implements CommandNotifier {

    @Override
    public void notify(Command command) {
        System.out.println(command);
    }
    
}
