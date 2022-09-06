/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import com.cg.cqrs.command.domain.CommandHandler;

/**
 *
 * @author cristian b
 */
public class TestCommandHandler implements CommandHandler<TestCommand> {
    
    private final TestCommandChecker checker;

    public TestCommandHandler(TestCommandChecker checker) {
        this.checker = checker;
    }
    
    @Override
    public String subscribedTo() {
        return TestCommand.class.getSimpleName();
    }

    @Override
    public void handle(TestCommand command){
        this.checker.check(command);
    }
    
}
