package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.dao.CategoryRepository;
import com.globant.bootcamp.EggCartonShopApi.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acat")
public class CategoryController {

        @Autowired
        CategoryRepository categoryRepository;

        @GetMapping
        public List <Category> getCat() {
                return categoryRepository.findAll();
        }

        @PostMapping
        public String insCat(@RequestBody Category category){
                categoryRepository.save(category);
                return "Categoria insertada";
        }

        @PutMapping
        public String updCat(@RequestBody Category category){

                categoryRepository.save(category);
                return "Categoria actualizada";

        }

        @DeleteMapping(value="/{id}")
        public String deleteProd(@PathVariable("id") Long id){
            categoryRepository.deleteById(id);
            return "Categoria eliminada";
        }
}
