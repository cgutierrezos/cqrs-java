/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cg.cqrs.querybus.domain;

import com.cg.cqrs.query.domain.Query;

/**
 *
 * @author cristian b
 */
public interface ExceptionQueryNotifier {
    
    /**
     *
     * @param e
     * @param query
     */
    public void notify(Exception e, Query query);
}
