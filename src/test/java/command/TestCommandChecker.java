/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author cristian b
 */
public class TestCommandChecker {
    
    private final TestCommand commandToCheck;
    private boolean checked;

    public TestCommandChecker(TestCommand commandToCheck) {
        this.commandToCheck = commandToCheck;
        this.checked = false;
    }
    
    public void check(TestCommand commandToCheck){
        this.checked = commandToCheck.equals(this.commandToCheck);
    }

    public boolean isChecked() {
        return this.checked;
    }
    
    
}
