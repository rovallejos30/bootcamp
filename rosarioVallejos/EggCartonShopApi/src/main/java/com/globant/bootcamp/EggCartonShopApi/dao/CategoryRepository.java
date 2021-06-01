package com.globant.bootcamp.EggCartonShopApi.dao;

import com.globant.bootcamp.EggCartonShopApi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
