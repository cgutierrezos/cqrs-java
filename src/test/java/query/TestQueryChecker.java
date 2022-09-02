/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package query;

/**
 *
 * @author cristian b
 */
public class TestQueryChecker {
    
    private final TestQuery queryToCheck;
    private boolean checked;
    
    public TestQueryChecker(TestQuery queryToCheck) {
        this.queryToCheck = queryToCheck;
        this.checked = false;
    }
    
    public void check(TestQuery queryToCheck){
        this.checked = queryToCheck.equals(this.queryToCheck);
    }

    public boolean isChecked() {
        return this.checked;
    }
    
    
    
}
