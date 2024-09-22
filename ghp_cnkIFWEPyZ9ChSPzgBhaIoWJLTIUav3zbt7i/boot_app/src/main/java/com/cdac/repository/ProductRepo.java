package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
