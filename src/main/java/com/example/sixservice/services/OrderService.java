package com.example.sixservice.services;

import java.util.ArrayList;

import com.example.sixservice.repositories.OrderRepository;
import com.example.sixservice.services.SecurityService;
import com.example.sixservice.repositories.TradeRepository;
import com.example.sixservice.models.OrderModel;
import com.example.sixservice.models.UserModel;
import com.example.sixservice.models.TradeModel;
import com.example.sixservice.models.SecurityModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @Autowired
    TradeService tradeService;

    public ArrayList<OrderModel> getOrders(){
        return (ArrayList<OrderModel>) orderRepository.findAll();
    }

    public OrderModel saveOrder(OrderModel order){  
        Long securityid = order.securityId;
        Long userId = order.userId;
        Double price = order.price;
        Double quantity = order.quantity;
        order.setFullfilled(false);
        orderRepository.save(order);

        ArrayList<SecurityModel> securities = securityService.getSecurities();
        ArrayList<UserModel> users = userService.getUsers();

        boolean foundSecurity = false;
        for (SecurityModel security : securities) {
            if (security.getId() == securityid) {
                foundSecurity = true;
                break;
            }
        }

        boolean foundUser = false;
        for (UserModel user : users) {
            if (user.getId() == userId) {
                foundUser = true;
                break;
            }
        }

        if (foundSecurity && foundUser) {
            matchOrders(securityid, price, quantity);
        }
        return null;
    }

    public ArrayList<OrderModel> getBySecurityId(Long securityId){
        return orderRepository.findBySecurityId(securityId);
    }

    public ArrayList<OrderModel> getBySecurityIdAndTypeAndPriceGreaterThanEqualOrderByPriceAsc(Long securityId, String type, Double price){
        return orderRepository.findBySecurityIdAndTypeAndPriceGreaterThanEqualOrderByPriceAsc(securityId, type, price);
    }

    public ArrayList<OrderModel> getBySecurityIdAndTypeAndPriceLessThanEqualOrderByPriceDesc(Long securityId, String type, Double price){
        return orderRepository.findBySecurityIdAndTypeAndPriceGreaterThanEqualOrderByPriceAsc(securityId, type, price);
    }

    public ArrayList<OrderModel> getBySecurityIdAndTypeOrderByPriceAsc(Long securityId, String type){
        return orderRepository.findBySecurityIdAndTypeOrderByPriceAsc(securityId, type);
    }

    public TradeModel matchOrders(Long securityId, Double price, Double quantity) {
        ArrayList<OrderModel> buyOrders = orderRepository.findBySecurityIdAndTypeOrderByPriceAsc(securityId, "buy");
        ArrayList<OrderModel> sellOrders = orderRepository.findBySecurityIdAndTypeOrderByPriceAsc(securityId, "sell");

        for (OrderModel buyOrder : buyOrders) {
            for (OrderModel sellOrder : sellOrders) {
                if (buyOrder.getQuantity() == 0 || sellOrder.getQuantity() == 0) {
                    continue;
                }
                if (buyOrder.getFullfilled() == true || sellOrder.getFullfilled() == true) {
                    continue;
                }
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    buyOrder.setFullfilled(true);
                    sellOrder.setFullfilled(true);
                    double tradePrice = sellOrder.getPrice();
                    double tradeQuantity = Math.min(buyOrder.getQuantity(), sellOrder.getQuantity());
                    Long buyOrderId = buyOrder.getId();
                    Long sellOrderId = sellOrder.getId();
                    TradeModel trade = new TradeModel();
                    trade.setPrice(tradePrice);
                    trade.setQuantity(tradeQuantity);
                    trade.setBuyOrderId(buyOrderId);
                    trade.setSellOrderId(sellOrderId);
                    tradeService.saveTrade(trade);
                    return trade;
                }
            }
        }
        return null;
    }
}