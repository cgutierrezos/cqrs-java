/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.commandnotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandbus.domain.CommandNotifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author cristian b
 */
public class ConsoleCommandNotifier implements CommandNotifier {
    
    private final Logger logger;

    public ConsoleCommandNotifier(Logger logger) {
        this.logger = logger;
    }
    
    @Override
    public void notify(Command command) {
        this.logger.debug(command);
    }
    
}
