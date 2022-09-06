/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain.querycollection;

import com.cg.cqrs.query.domain.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author cristian b
 */
public class QueryCollection<T extends Query> {
    private final Collection<T> queries;
    
    public QueryCollection() {
        this.queries = new ArrayList<>();
    }
    
    public void add(T query) {
        this.queries.add(query);
    }
    
    public Iterator<T> iterator() {
        return this.queries.iterator();
    }
    
    public QueryFilter<T> filter() {
        return new QueryFilter(this.queries);
    }
    
    
    public int size() {
        return this.queries.size();
    }
}
