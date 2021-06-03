package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.model.Product;

import java.util.List;

public interface ProductService {

	 List<Product> listProduct();

	 List<Product> findByCategory(Long categoryId);

}
