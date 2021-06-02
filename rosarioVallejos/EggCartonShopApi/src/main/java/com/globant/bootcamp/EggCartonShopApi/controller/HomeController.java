package com.globant.bootcamp.EggCartonShopApi.controller;

import com.globant.bootcamp.EggCartonShopApi.model.User;
import com.globant.bootcamp.EggCartonShopApi.service.CategoryService;
import com.globant.bootcamp.EggCartonShopApi.service.ProductService;
import com.globant.bootcamp.EggCartonShopApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;

	@GetMapping({"index", "/"})
	public String index(Model model) {
		model.addAttribute("categoryList", categoryService.listCategory());
		model.addAttribute("productList", productService.listProduct());
		return "index";
	}

	@GetMapping("allProduct")
	public String allProduct(Model model) {
		model.addAttribute("productList", productService.listProduct());
		model.addAttribute("categoryList", categoryService.listCategory());
		return "index";
	}

		@GetMapping("getProducts/{categoryId}")
		public ModelAndView getProductFromCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("index");
		long categoryLongId = Long.parseLong(categoryId);
		System.out.println(categoryLongId);
		mv.addObject("productList", productService.findByCategory(categoryLongId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}

	@GetMapping("/indexes")
	public String indexes (Model model){
		model.addAttribute("user", userService.listUsers());
		return "indexes";
	}

}
