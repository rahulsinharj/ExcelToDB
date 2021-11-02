package com.libapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libapi.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	
} 
