package org.Clumsy.dao.operations;

import org.Clumsy.entity.Order;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */
public interface OrderOperations {

    List<Order> findOrdersByType(String t);
}
