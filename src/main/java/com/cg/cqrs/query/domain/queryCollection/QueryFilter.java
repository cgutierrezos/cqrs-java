package com.cg.cqrs.query.domain.querycollection;

import com.cg.cqrs.query.domain.Query;
import java.util.Collection;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author cristian b
 * @param <T>
 */
public class QueryFilter<T extends Query> {
    
    public interface FilterCallback<T extends Query> {
        public boolean filter(T query);
    }
    
    private final Collection<T> queries;

    /**
     *
     * @param queries
     */
    public QueryFilter(Collection<T> queries) {
        this.queries = queries;
    }

    /**
     *
     * @param queryClass
     * @return
     */
    public QueryCollection<T> findManyByClass(Class<T> queryClass) {
        return this.findMany((T query) -> 
                queryClass.equals(query.getClass())
        );
    }
    
    /**
     *
     * @param queryID
     * @return
     */
    public T findOneByID(String queryID){
        return this.findOne((T query) ->
                queryID.equals(query.queryID())
        );
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public T findOne(FilterCallback<T> callback){
        Iterator<T> iterator = this.queries.iterator();
        
        while(iterator.hasNext()) {
            T query = iterator.next();
            
            if(callback.filter(query)) {
                return query;
            }
        }
        
        return null;
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public QueryCollection<T> findMany(FilterCallback<T> callback) {
        QueryCollection<T> filtered =  new QueryCollection();
        
        Iterator<T> iterator = this.queries.iterator();
        
        while(iterator.hasNext()) {
            T query = iterator.next();
            
            if(callback.filter(query)) {
                filtered.add(query);
            }
        }
        
        return filtered;
    }
}
