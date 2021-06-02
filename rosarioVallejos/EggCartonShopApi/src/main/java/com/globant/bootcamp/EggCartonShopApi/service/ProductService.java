package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.model.Product;

import java.util.List;

public interface ProductService {

	public List<Product> listProduct();

	public List<Product> findByCategory(Long categoryId);

}
