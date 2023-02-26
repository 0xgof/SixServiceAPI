package com.example.sixservice.repositories;

import java.util.ArrayList;

import com.example.sixservice.models.OrderModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderModel, Long> {
    public abstract ArrayList<OrderModel> findBySecurityIdAndTypeAndPriceLessThanEqualOrderByPriceDesc(Long securityId, String type, Double price);
    public abstract ArrayList<OrderModel> findBySecurityIdAndTypeAndPriceGreaterThanEqualOrderByPriceAsc(Long securityId, String type, Double price);
    public abstract ArrayList<OrderModel> findBySecurityIdAndTypeOrderByPriceAsc(Long securityId, String type);
    public abstract ArrayList<OrderModel> findBySecurityId(Long securityId);
}