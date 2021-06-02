package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.dao.ProductRepository;
import com.globant.bootcamp.EggCartonShopApi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> listProduct() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByCategory(Long categoryId) {
		return productRepository.findByCategory_CategoryId(categoryId);
	}


}
