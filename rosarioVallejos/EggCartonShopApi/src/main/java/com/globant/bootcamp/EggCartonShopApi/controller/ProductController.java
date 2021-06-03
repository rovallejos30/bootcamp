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
    public String insProd(@RequestBody Product product){

        productRepository.save(product);
        return "Producto creado";

    }

    @PutMapping
    public String updProd(@RequestBody Product product){

        productRepository.save(product);
        return "Producto actualizado";

    }

    @DeleteMapping(value="/{id}")
    public String deleteProd(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return "Producto eliminado";

    }



}
