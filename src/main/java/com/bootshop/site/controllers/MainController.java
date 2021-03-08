package com.bootshop.site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootshop.site.entities.Brand;
import com.bootshop.site.entities.Color;
import com.bootshop.site.entities.OrderAddress;
import com.bootshop.site.entities.Size;
import com.bootshop.site.entities.Style;
import com.bootshop.site.entities.User;
import com.bootshop.site.services.BrandService;
import com.bootshop.site.services.ColorService;
import com.bootshop.site.services.OrderAddressService;
import com.bootshop.site.services.SizeService;
import com.bootshop.site.services.StyleService;
import com.bootshop.site.services.UserService;
import com.bootshop.site.user.CustomUserDetails;

@Controller
public class MainController {
	
	@Autowired
	private SizeService sizeService;
	@Autowired
	private UserService userService;
	@Autowired
	private StyleService styleService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Size> listSizes = sizeService.getAllSize();
		List<Style> listStyles = styleService.getAllStyle();
		List<Color> listColors = colorService.getAllColor();
		List<Brand> listBrands = brandService.getAllBrand();
		model.addAttribute("listSizes", listSizes);
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
		boolean error = false;
		if (save != null) {
			message = "You have signed up succesfully";
		} else {
			error = true;
			message = "Error signed up";
		}
		redirectAttributes.addFlashAttribute("error", error);
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:login";
	}
}
