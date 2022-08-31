package com.cg.cqrs.query.domain.queryCollection;

import com.cg.cqrs.query.domain.Query;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author cristian b
 */
public class QueryFilter {
    
    public interface filterCallback {
        public boolean filter(Query query);
    }
    
    private final ArrayList<Query> queries;

    /**
     *
     * @param queries
     */
    public QueryFilter(ArrayList<Query> queries) {
        this.queries = queries;
    }

    /**
     *
     * @param queryClass
     * @return
     */
    public QueryCollection findManyByClass(Class<Query> queryClass) {
        return this.findMany((query) -> {
            return queryClass.equals(query.getClass());
        });
    }
    
    /**
     *
     * @param queryID
     * @return
     */
    public Query findOneByID(String queryID){
        return this.findOne((query) -> {
            return queryID.equals(query.queryID());
        });
    }
    
    /**
     *
     * @param callback
     * @return
     */
    public Query findOne(filterCallback callback){
        Iterator<Query> iterator = this.queries.iterator();
        
        while(iterator.hasNext()) {
            Query query = iterator.next();
            
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
    public QueryCollection findMany(filterCallback callback) {
        QueryCollection filtered =  new QueryCollection();
        
        Iterator<Query> iterator = this.queries.iterator();
        
        while(iterator.hasNext()) {
            Query query = iterator.next();
            
            if(callback.filter(query)) {
                filtered.add(query);
            }
        }
        
        return filtered;
    }
}
