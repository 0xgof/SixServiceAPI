package com.example.sixservice.controllers;

import java.util.ArrayList;

import com.example.sixservice.models.OrderModel;
import com.example.sixservice.services.OrderService;
import com.example.sixservice.repositories.OrderRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    OrderRepository orderRepository;

    @GetMapping()
    public ArrayList<OrderModel> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/price_greater_or_equal")
    public ArrayList<OrderModel> getSellOrders(@RequestParam(value = "securityId") Long securityId, 
                                                @RequestParam(value = "type") String type, 
                                                @RequestParam(value = "price") Double price) {
        return this.orderService.getBySecurityIdAndTypeAndPriceGreaterThanEqualOrderByPriceAsc(securityId, type, price);
    }

    @GetMapping("/price_less_or_equal")
    public ArrayList<OrderModel> getBuyOrders(@RequestParam(value = "securityId") Long securityId, 
                                                @RequestParam(value = "type") String type, 
                                                @RequestParam(value = "price") Double price) {
        return this.orderService.getBySecurityIdAndTypeAndPriceLessThanEqualOrderByPriceDesc(securityId, type, price);
    }

    @GetMapping("/bySecurityIdAndType")
    public ArrayList<OrderModel> getOrdersBySecurityIdAndTypeOrderByPriceAsc(@RequestParam(value = "securityId") Long securityId, 
                                                @RequestParam(value = "type") String type) {
        return this.orderService.getBySecurityIdAndTypeOrderByPriceAsc(securityId, type);
    }

    @GetMapping( path = "/query")
    public ArrayList<OrderModel> getBySecurityId(@RequestParam("securityId") Long securityId) {
        return this.orderService.getBySecurityId(securityId);
    }

    @PostMapping()
    public OrderModel saveOrder(@RequestBody OrderModel order){
        return this.orderService.saveOrder(order);
    }

}