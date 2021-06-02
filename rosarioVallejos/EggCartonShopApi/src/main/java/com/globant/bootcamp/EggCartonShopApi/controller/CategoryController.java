package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.dao.CategoryRepository;
import com.globant.bootcamp.EggCartonShopApi.dao.ProductRepository;
import com.globant.bootcamp.EggCartonShopApi.model.Category;
import com.globant.bootcamp.EggCartonShopApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acat")
public class CategoryController {

        @Autowired
        CategoryRepository categoryRepository;

        @GetMapping
        public List<Category> getCat() {
            return categoryRepository.findAll();
        }

        @PostMapping
        public void insCat(@RequestBody Category category){ categoryRepository.save(category);}

        @PutMapping
        public void updCat(@RequestBody Category category){
            categoryRepository.save(category);
        }

        @DeleteMapping(value="/{id}")
        public void deleteProd(@PathVariable("id") Long id){
            categoryRepository.deleteById(id);

        }
}
