package org.Clumsy.controller;

import org.Clumsy.entity.Order;
import org.Clumsy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by slow_time on 2017/7/12.
 */
@Controller
@RequestMapping("/orderinfo")
public class UserInfoHandler {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/showOrderByJson")
    public List<Order> returnJson() {
        return orderService.getAllOrders();
    }
}
