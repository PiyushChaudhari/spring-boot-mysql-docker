package com.learning.springbootmysqldocker.repository;

import com.learning.springbootmysqldocker.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
