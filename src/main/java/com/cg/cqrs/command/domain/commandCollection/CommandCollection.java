/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandCollection;

import com.cg.cqrs.command.domain.Command;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author cristian b
 */
public class CommandCollection {
    
    public interface EachCallback {
        public void each(Command command);
    }
    
    private final ArrayList<Command> comands;

    public CommandCollection() {
        this.comands = new ArrayList<>();
    }
    
    
    public void add(Command command){
        this.comands.add(command);
    }
    
    public Iterator<Command> iterator() {
        return this.comands.iterator();
    }
    
    public CommandFilter filter(){
        return new CommandFilter(this.comands);
    }
    
    
    public void forEach(EachCallback callback) {
        for (Command comand : this.comands) {
            callback.each(comand);
        }
    }
    
    public int size() {
        return this.comands.size();
    }
}
