package com.mysmartshop.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysmartshop.product.model.Product;

public interface ProductRepo extends JpaRepository<Product,String> {

}
