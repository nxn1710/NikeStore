package com.bootshop.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootshop.site.entities.Product;
import com.bootshop.site.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/products", "/products/{category}" })
	public String listFirstPage(Model model, @PathVariable(value = "category", required = false) String category) {
		return listByPage(model, 1, category);
	}

	@PostMapping(value = { "/products" })
	public String findProduct(Model model, @RequestParam("categoryId") Integer categoryId,
			@RequestParam("colorId") Integer colorId, @RequestParam("styleId") Integer styleId,
			@RequestParam("brandId") Integer brandId) {
			Integer productPerPage = 8;
			model.addAttribute("title", "Your result");
			Page<Product> page = productService.getFindProduct(1, categoryId, colorId, styleId, brandId);
			model.addAttribute("listProducts", page.getContent());
			model.addAttribute("totalItems", page.getTotalElements());
			model.addAttribute("currPage", 1);
			model.addAttribute("totalPages", page.getTotalPages());
			return "products";
	}

	@GetMapping(value = { "/products/page/{pageNumber}", "/products/{category}/page/{pageNumber}" })
	public String listByPage(Model model, @PathVariable(name = "pageNumber") Integer numPage,
			@PathVariable(value = "category", required = false) String category) {
		Integer productPerPage = 8;
		int categoryId = 0;
		String title = "All Products";
		if (category != null) {
			if (category.equals("men")) {
				categoryId = 1;
				title = "Men Products";
			} else if (category.equals("women")) {
				categoryId = 2;
				title = "Women Products";
			}
		}
		Page<Product> page = productService.getListProducts(numPage, productPerPage, categoryId);
		model.addAttribute("title", title);
		model.addAttribute("category", category);
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("currPage", numPage);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("listProducts", page.getContent());
		return "products";
	}

	@GetMapping("/p/{slug}")
	public String viewProductDetails(Model model, @PathVariable(name = "slug") String productSlug) {
		Product product = productService.getProductBySlug(productSlug);
		model.addAttribute("product", product);
		return "details";
	}
}
