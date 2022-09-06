/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandcollection;

import com.cg.cqrs.command.domain.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class CommandCollection<T extends Command> {
    
    private final Collection<T> comands;

    public CommandCollection() {
        this.comands = new ArrayList<>();
    }

    protected CommandCollection(Collection<T> comands) {
        this.comands = comands;
    }
    
    
    public void add(T command){
        this.comands.add(command);
    }
    
    public Iterator<T> iterator() {
        return this.comands.iterator();
    }
    
    public CommandFilter<T> filter(){
        return new CommandFilter(this.comands);
    }
    
    public int size() {
        return this.comands.size();
    }
}
