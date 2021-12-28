package com.learning.springbootmysqldocker.service;

import com.learning.springbootmysqldocker.entity.Product;
import com.learning.springbootmysqldocker.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> readProducts () {
        logger.info("readProducts");
        return productRepository.findAll();
    }

    public Product get (String id) {
        logger.info("get {}",id);
        return productRepository.findById(new Long(id)).get();
    }

    public void save(Product product){
        logger.info("save {}",product);
        productRepository.save(product);
    }
}
