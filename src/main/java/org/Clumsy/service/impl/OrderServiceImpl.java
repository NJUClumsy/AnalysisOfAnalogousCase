package org.Clumsy.service.impl;

import org.Clumsy.dao.OrderRepository;
import org.Clumsy.entity.Order;
import org.Clumsy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slow_time on 2017/7/15.
 */


//使用@Service注解在Spring容器中注册名为orderService的OrderServiceImpl实例
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersByCustomer(String name) {
        return orderRepository.findByCustomer(name);
    }

    @Override
    public List<String> getOrdersByType(String type) {
        return orderRepository.findOrdersByType(type).stream().map(Order::getType).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
