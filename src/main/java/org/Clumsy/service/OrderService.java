package org.Clumsy.service;

import org.Clumsy.entity.Order;

import java.util.List;

/**
 * Created by slow_time on 2017/7/15.
 */
public interface OrderService {

    List<Order> getOrdersByCustomer(String name);

    List<Order> getAllOrders();
}
