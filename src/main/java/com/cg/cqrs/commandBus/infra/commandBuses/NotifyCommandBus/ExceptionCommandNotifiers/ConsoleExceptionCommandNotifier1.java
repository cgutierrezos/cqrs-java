/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.exceptioncommandnotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandbus.domain.ExceptionCommandNotifier;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cristian b
 */
public class ConsoleExceptionCommandNotifier1 implements ExceptionCommandNotifier{

    private final Logger logger;

    public ConsoleExceptionCommandNotifier1(Logger logger) {
        this.logger = logger;
    }
    
    
    
    @Override
    public void notify(Exception e, Command command) {
        this.logger.debug(e);
        this.logger.debug(command);
    }
    
}
