/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain.queryAskerCollection;

import com.cg.cqrs.query.domain.QueryAsker;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author cristian b
 */
public class QueryAskerCollection {
    
    public interface ForEachCallback {
        public void next(QueryAsker asker);
    }
    private final ArrayList<QueryAsker> askers;

    public QueryAskerCollection() {
        this.askers = new ArrayList<>();
    }
    
    public void add(QueryAsker asker){
        this.askers.add(asker);
    }
    
    public Iterator<QueryAsker> iterator() {
        return this.askers.iterator();
    }
    
    public void forEach(ForEachCallback callback) {
        for (QueryAsker asker : this.askers) {
            callback.next(asker);
        }
    }
    
    public QueryAskerFilter filter() {
        return new QueryAskerFilter(this.askers);
    }
}
