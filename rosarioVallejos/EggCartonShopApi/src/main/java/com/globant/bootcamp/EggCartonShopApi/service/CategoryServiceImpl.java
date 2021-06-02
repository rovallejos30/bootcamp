package com.globant.bootcamp.EggCartonShopApi.service;

import com.globant.bootcamp.EggCartonShopApi.dao.CategoryRepository;
import com.globant.bootcamp.EggCartonShopApi.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public Optional<Category> getCategory(Long categoryId) {
		return categoryRepository.findById(categoryId);
	}

}
