package org.Clumsy.controller;

import org.Clumsy.entity.Order;
import org.Clumsy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by slow_time on 2017/7/12.
 */
@Controller
@RequestMapping("/orderinfo")
public class OrderInfoController {

    @Autowired
    private OrderService orderService;


    @ResponseBody
    @RequestMapping(value = "/showOrderByJson", method = RequestMethod.GET)
    public List<Order> returnJson() {
        return orderService.getAllOrders();
    }
}
