package com.example.sixservice.services;

import java.util.ArrayList;

import com.example.sixservice.repositories.TradeRepository;
import com.example.sixservice.models.TradeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    @Autowired
    TradeRepository tradeRepository;

    public ArrayList<TradeModel> getTrades(){
        return (ArrayList<TradeModel>) tradeRepository.findAll();
    }

    public TradeModel saveTrade(TradeModel trade){
        return tradeRepository.save(trade);
    }

    public ArrayList<TradeModel> getBySellOrderId(Long sellOrderId){
        return tradeRepository.findBySellOrderId(sellOrderId);
    }

    public ArrayList<TradeModel> getByBuyOrderId(Long buyOrderId){
        return tradeRepository.findByBuyOrderId(buyOrderId);
    }
}