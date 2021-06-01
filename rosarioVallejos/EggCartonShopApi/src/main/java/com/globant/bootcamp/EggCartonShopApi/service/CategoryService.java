package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
	
	public void addCategory(Category category);
	
	public List<Category> listCategory();
	
	public void deleteCategory(long categoryId);
	
	public void updateCategory(Category category);
	
	public Optional<Category> getCategory(long categoryId);
	
}
