/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain.queryAskerCollection;

import com.cg.cqrs.query.domain.QueryAsker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 *
 * @author cristian b
 * @param <T>
 */
public class QueryAskerCollection<T extends QueryAsker> {
    
    
    private final Collection<T> askers;

    public QueryAskerCollection() {
        this.askers = new ArrayList<>();
    }
    
    public void add(T asker){
        this.askers.add(asker);
    }
    
    public Iterator<T> iterator() {
        return this.askers.iterator();
    }
    
    public QueryAskerFilter<T> filter() {
        return new QueryAskerFilter(this.askers);
    }
}
