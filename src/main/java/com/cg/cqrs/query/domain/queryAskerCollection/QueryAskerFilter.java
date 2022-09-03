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
 * @param <T>
 */
public class QueryAskerFilter<T extends QueryAsker> {
    
    public interface FilterCallback<T extends QueryAsker> {
        public boolean filter(T asker);
    }
    
    private final Collection<T> askers;

    public QueryAskerFilter(Collection<T> askers) {
        this.askers = askers;
    }
    
    
    public T findOneByQueryClass(Class<T> queryClass){
        return this.findOne((T asker) -> {
            return queryClass.getSimpleName().equals(asker.subscribedTo());
        });
    }
    
    public T findOne(FilterCallback<T> callback) {
        for (T asker : this.askers) {
            if(callback.filter(asker)){
                return asker;
            }
        }
        
        return null;
    }
}
