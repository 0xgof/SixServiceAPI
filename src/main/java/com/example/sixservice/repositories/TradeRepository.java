package com.example.sixservice.repositories;

import java.util.ArrayList;

import com.example.sixservice.models.TradeModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends CrudRepository<TradeModel, Long> {
    public abstract ArrayList<TradeModel> findBySellOrderId(Long sellOrderId);
    public abstract ArrayList<TradeModel> findByBuyOrderId(Long buyOrderId);

}