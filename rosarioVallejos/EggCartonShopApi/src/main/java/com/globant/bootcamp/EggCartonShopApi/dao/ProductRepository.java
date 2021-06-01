package com.globant.bootcamp.EggCartonShopApi.dao;

import com.globant.bootcamp.EggCartonShopApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByCategory_CategoryId(long CategoryId);
	
}
