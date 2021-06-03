package com.globant.bootcamp.EggCartonShopApi.repository;

import com.globant.bootcamp.EggCartonShopApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory_CategoryId(long CategoryId);
	
}
