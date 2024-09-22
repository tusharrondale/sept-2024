package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {

}
