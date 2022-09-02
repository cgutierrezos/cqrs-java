/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

/**
 *
 * @author cristian b
 */
public class TestCommandMessage {
    
    private final String id;
    private final String foo;

    /**
     *
     * @param id
     * @param foo
     */
    public TestCommandMessage(String id, String foo) {
        this.id = id;
        this.foo = foo;
    }

    /**
     *
     * @return
     */
    public String id() {
        return id;
    }

    /**
     *
     * @return
     */
    public String foo() {
        return foo;
    }
    
    
    
}
