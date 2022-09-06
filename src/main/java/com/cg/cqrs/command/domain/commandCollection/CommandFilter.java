/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.command.domain.commandcollection;

import com.cg.cqrs.command.domain.Command;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 * @param <T>
 */
public class CommandFilter<T extends Command> {

    /**
     *
     * @param <T>
     */
    public interface FilterCallback<T extends Command> {

        public boolean filter(T command);
    }

    private final Collection<T> commands;

    /**
     *
     * @param commands
     */
    public CommandFilter(Collection<T> commands) {
        this.commands = commands;
    }

    /**
     *
     * @param commandClass
     * @return
     */
    public CommandCollection<T> findManyByClass(Class<T> commandClass) {

        return this.findMany((T command) ->
                commandClass.equals(command.getClass())
        );
    }

    /**
     *
     * @param id
     * @return
     */
    public T findOneByID(String id) {

        return this.findOne((T command) ->
                id.equals(command.commandId())
        );
    }

    /**
     *
     * @param callback
     * @return
     */
    public T findOne(FilterCallback<T> callback) {
        Iterator<T> iterator = this.commands.iterator();

        while (iterator.hasNext()) {
            T command = iterator.next();

            if (callback.filter(command)) {
                return command;
            }
        }

        return null;
    }

    /**
     *
     * @param callback
     * @return
     */
    public CommandCollection<T> findMany(FilterCallback<T> callback) {

        CommandCollection<T> filtered = new CommandCollection();

        Iterator<T> iterator = this.commands.iterator();
        while (iterator.hasNext()) {
            T command = iterator.next();

            if (callback.filter(command)) {
                filtered.add(command);
            }
        }

        return filtered;
    }
}
