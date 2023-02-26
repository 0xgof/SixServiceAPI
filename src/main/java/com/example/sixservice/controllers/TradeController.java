package com.example.sixservice.controllers;

import java.util.ArrayList;

import com.example.sixservice.models.TradeModel;
import com.example.sixservice.services.TradeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/trade")
public class TradeController {
    @Autowired
    TradeService tradeService;

    @GetMapping()
    public ArrayList<TradeModel> getTrades(){
        return tradeService.getTrades();
    }

    @PostMapping()
    public TradeModel saveTrade(@RequestBody TradeModel trade){
        return this.tradeService.saveTrade(trade);
    }
   
    @GetMapping( path = "/bySell")
    public ArrayList<TradeModel> getBySellOrderId(@RequestParam("sellOrderId") Long sellOrderId) {
        return this.tradeService.getBySellOrderId(sellOrderId);
    }

    @GetMapping( path = "/byBuy")
    public ArrayList<TradeModel> getByBuyOrderId(@RequestParam("buyOrderId") Long buyOrderId) {
        return this.tradeService.getByBuyOrderId(buyOrderId);
    }
}