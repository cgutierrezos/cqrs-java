/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain.queryCollection;

import com.cg.cqrs.query.domain.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author cristian b
 */
public class QueryCollection {
    private final ArrayList<Query> queries;
    
    public interface EachCallback {
        public void each(Query query);
    }

    public QueryCollection() {
        this.queries = new ArrayList<>();
    }
    
    public void add(Query query) {
        this.queries.add(query);
    }
    
    public Iterator<Query> iterator() {
        return this.queries.iterator();
    }
    
    public QueryFilter filter() {
        return new QueryFilter(this.queries);
    }
    
    public void forEach(EachCallback callback) {
        for (Query query : this.queries) {
            callback.each(query);
        }
    }
    
    
    
    public int size() {
        return this.queries.size();
    }
}
