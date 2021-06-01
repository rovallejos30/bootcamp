package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.dao.ProductRepository;
import com.globant.bootcamp.EggCartonShopApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aprod")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> getProd() {
        return productRepository.findAll();
    }

    @PostMapping
    public void insertProd(@RequestBody Product product){
        productRepository.save(product);
    }

    @PutMapping
    public void updateProd(@RequestBody Product product){
        productRepository.save(product);
    }

    @DeleteMapping(value="/{id}")
    public void deleteProd(@PathVariable("id") Long id){
        productRepository.deleteById(id);

    }



}
