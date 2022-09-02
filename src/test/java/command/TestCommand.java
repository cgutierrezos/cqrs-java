/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import com.cg.cqrs.command.domain.Command;
import com.cg.cqrs.command.domain.CommandHeader;

/**
 *
 * @author cristian b
 */
public class TestCommand extends Command {
    
    private final TestCommandMessage message;

    /**
     *
     * @param message
     * @param header
     */
    public TestCommand(TestCommandMessage message, CommandHeader header) {
        super(header);
        this.message = message;
    }
    
    
    public String id(){
        return this.message.id();
    }
    
    public String foo() {
        return this.message.foo();
    }
    
}
