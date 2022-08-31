/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cg.cqrs.query.domain.queryAskerCollection;

import com.cg.cqrs.query.domain.Query;
import com.cg.cqrs.query.domain.QueryAsker;
import java.util.Collection;

/**
 *
 * @author cristian b
 */
public class QueryAskerFilter {
    
    public interface FilterCallback {
        public boolean filter(QueryAsker asker);
    }
    
    private final Collection<QueryAsker> askers;

    public QueryAskerFilter(Collection<QueryAsker> askers) {
        this.askers = askers;
    }
    
    
    public <T extends Query>QueryAsker findOneByQueryClass(Class<T> queryClass){
        return this.findOne((QueryAsker asker) -> {
            return queryClass.getSimpleName().equals(asker.subscribedTo());
        });
    }
    
    public QueryAsker findOne(FilterCallback callback) {
        for (QueryAsker asker : this.askers) {
            if(callback.filter(asker)){
                return asker;
            }
        }
        
        return null;
    }
}
