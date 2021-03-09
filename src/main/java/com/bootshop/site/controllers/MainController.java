package com.bootshop.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootshop.site.entities.Brand;
import com.bootshop.site.entities.Category;
import com.bootshop.site.entities.Color;
import com.bootshop.site.entities.Product;
import com.bootshop.site.entities.Style;
import com.bootshop.site.entities.User;
import com.bootshop.site.services.BrandService;
import com.bootshop.site.services.CategoryService;
import com.bootshop.site.services.ColorService;
import com.bootshop.site.services.ProductService;
import com.bootshop.site.services.StyleService;
import com.bootshop.site.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private StyleService styleService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Category> listCategories = categoryService.getAllCategory();
		List<Style> listStyles = styleService.getAllStyle();
		List<Color> listColors = colorService.getAllColor();
		List<Brand> listBrands = brandService.getAllBrand();
		List<Product> listNewProduct = productService.getNewProduct();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("listNewProduct", listNewProduct);
		model.addAttribute("listStyles", listStyles);
		model.addAttribute("listColors", listColors);
		model.addAttribute("listBrands", listBrands);
		return "index";
	}
	
	@GetMapping("/login")
	public String viewLoginPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@GetMapping("/admin")
	public String viewAdminPage(Model model) {
		return "admin/2222";
	}
	
	@GetMapping("/bag")
	public String viewBagPage() {
		return "bag";
	}

	
	@PostMapping("/process_register")
	public String registerUser(User user, RedirectAttributes redirectAttributes) {
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User save = userService.save(user);
		String message;
		System.out.println("ahsdhsahdsahdhs");
		boolean error = false;
		if (save != null) {
			message = "You have signed up succesfully";
		} else {
			error = true;
			message = "Error signed up";
		}
		redirectAttributes.addFlashAttribute("error", error);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/login";
	}
}
