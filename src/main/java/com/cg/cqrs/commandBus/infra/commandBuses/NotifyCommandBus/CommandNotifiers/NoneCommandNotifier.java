/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cg.cqrs.commandbus.infra.commandbuses.notifycommandbus.commandnotifiers;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.commandbus.domain.CommandNotifier;

/**
 *
 * @author cristian b
 */
public class NoneCommandNotifier implements CommandNotifier {

    @Override
    public void notify(Command command) {
        // NONE NOTIFICATION
    }
    
}
