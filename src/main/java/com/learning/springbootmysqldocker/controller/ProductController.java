package com.learning.springbootmysqldocker.controller;

import com.learning.springbootmysqldocker.entity.Product;
import com.learning.springbootmysqldocker.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> get(@PathVariable("id") String id) {
        logger.info("Get Called with ID: [{}]",id);
        return new ResponseEntity<Product>(productService.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> list() {
        logger.info("List Called.");
        return new ResponseEntity<List<Product>>(productService.readProducts(),HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product) {
        logger.info("Save Called with ID: [{}]",product);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
