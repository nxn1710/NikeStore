package com.bootshop.site.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootshop.site.entities.Item;
import com.bootshop.site.entities.Order;
import com.bootshop.site.entities.OrderAddress;
import com.bootshop.site.entities.OrderDetails;
import com.bootshop.site.entities.ProductsSizes;
import com.bootshop.site.entities.User;
import com.bootshop.site.exceptions.QuantityOutOfStock;
import com.bootshop.site.services.OrderAddressService;
import com.bootshop.site.services.OrderDetailsService;
import com.bootshop.site.services.OrderService;
import com.bootshop.site.services.ProductsSizeService;
import com.bootshop.site.services.UserService;
import com.bootshop.site.user.CustomUserDetails;

@Controller
public class OrderController {
	@Autowired
	private ProductsSizeService service;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderAddressService addressService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDetailsService orderDetailsService;
	@PostMapping("/bag")
	public String addToCart(Model model, HttpSession session, HttpServletRequest request) throws QuantityOutOfStock {
		// @AuthenticationPrincipal CustomUserDetails loggedUser,
		Integer productSizeId = Integer.parseInt(request.getParameter("productSize"));
		// String email = loggedUser.getUsername();
		// User user = userService.getByEmail(email);
		ProductsSizes productsSizes = service.getById(productSizeId);
		List<Item> bag = (List<Item>) session.getAttribute("bag");
		if (bag == null) {
			bag = new ArrayList<>();
			bag.add(new Item(productsSizes, 1));
		} else {
			int index = findProductInBag(productSizeId, bag);
			if (index == -1) {
				bag.add(new Item(productsSizes, 1));
			} else {
				if (bag.get(index).getProductsSizes().getQuantity() >= bag.get(index).getQuantity() + 1) {
					bag.get(index).setQuantity(bag.get(index).getQuantity() + 1);
					model.addAttribute("message", "Successful update of purchases from the bag ");
				} else {
					model.addAttribute("message", "Not available quantity in store");
				}
			}
		}
		session.setAttribute("bag", bag);
		return "bag";
	}

	@GetMapping("/bag/remove/{id}")
	public String removeItemFromBag(@PathVariable(name = "id") Integer id, HttpSession session, Model model) {
		List<Item> bag = (List<Item>) session.getAttribute("bag");
		if (bag == null) {
			return "bag";
		} else {
			int index = findProductInBag(id, bag);
			if (index == -1) {
				return "bag";
			} else {
				model.addAttribute("message", "Remove Product from bag successfully");
				bag.remove(index);
				if (bag.size() == 0) {
					session.removeAttribute("bag");
					return "bag";
				}
			}
		}
		session.setAttribute("bag", bag);
		return "bag";
	}

	public int findProductInBag(Integer id, List<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getProductsSizes().getId() == id) {
				return i;
			}
		}
		return -1;
	}

	@GetMapping("/updatebag/{id}/{quantity}")
	public String removeItemFromBag(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "quantity") Integer quantity, HttpSession session, Model model)
			throws QuantityOutOfStock {
		List<Item> bag = (List<Item>) session.getAttribute("bag");
		if (bag == null) {
			return "bag";
		} else {
			int index = findProductInBag(id, bag);
			if (index == -1) {
				return "bag";
			} else {
				if (bag.get(index).getProductsSizes().getQuantity() >= quantity) {
					bag.get(index).setQuantity(quantity);
					model.addAttribute("message", "Successful update of purchases from the bag ");
				} else {
					model.addAttribute("message", "Not available quantity in store");
				}
			}
		}
		session.setAttribute("bag", bag);
		return "bag";
	}

	@GetMapping("/checkout")
	public String viewCheckoutPage(@AuthenticationPrincipal CustomUserDetails loggedUser, Model model) {
		User user = userService.getByEmail(loggedUser.getUsername());
		String fullName = user.getFirstName() + " " + user.getLastName();
		model.addAttribute("addresses", user.getOrderAddresses());
		model.addAttribute("fullName", fullName);
		OrderAddress orderAddress = new OrderAddress();
		model.addAttribute("address", orderAddress);
		return "checkout";
	}

	@PostMapping("/finishcheckout")
	public String viewCheckoutPage(@AuthenticationPrincipal CustomUserDetails loggedUser,
			RedirectAttributes redirectAttributes, @RequestParam("address") Integer addressId, Model model,
			HttpSession session) {
		User user = userService.getByEmail(loggedUser.getUsername());
		boolean isTrueAddress = false;
		for (OrderAddress orderAddress : user.getOrderAddresses()) {
			if (orderAddress.getId() == addressId) {
				isTrueAddress = true;
				break;
			}
		}
		if (isTrueAddress) {
			Order order = new Order();
			order.setOrderAddress(addressService.getById(addressId));
			order.setStatus(false);
			order.setTime(new Date());
			order = orderService.save(order);
			List<Item> items = (List<Item>) session.getAttribute("bag");
			for (Item item : items) {
				OrderDetails orderDetails = new OrderDetails();
				orderDetails.setOrder(order);
				orderDetails.setProductsSizes(item.getProductsSizes());
				orderDetails.setQuantity(item.getQuantity());
				orderDetails.setPrice(item.getProductsSizes().getProduct().getPrice() * item.getQuantity());
				orderDetailsService.save(orderDetails);
			}
			session.removeAttribute("bag");
		} else {
			redirectAttributes.addFlashAttribute("message", "Address is invalid, Please choose another address");
		}
		redirectAttributes.addFlashAttribute("message", "Order successfully, your order has been saved in order history ");
		return "redirect:orders";
	}

	@PostMapping("/newaddress")
	public String newAddress(@AuthenticationPrincipal CustomUserDetails loggedUser, OrderAddress orderAddress) {
		User user = userService.getByEmail(loggedUser.getUsername());
		orderAddress.setUser(user);
		addressService.save(orderAddress);
		return "redirect:checkout";
	}
	
	@GetMapping("/orders")
	public String viewOrdersPage(@AuthenticationPrincipal CustomUserDetails loggedUser, Model model) {
		model.addAttribute("orders", orderService.getOrdersByUser(loggedUser.getUsername()));
		return "orders";
	}
	
	@GetMapping("/orders/view/{id}")
	public String viewOrderPage(@AuthenticationPrincipal CustomUserDetails loggedUser, @PathVariable("id") Integer id, Model model,RedirectAttributes redirectAttributes) {
		User user = userService.getByEmail(loggedUser.getUsername());
		Order order = orderService.getById(id);
		if (order == null || order.getOrderAddress().getUser().getId() != user.getId() ) {
			redirectAttributes.addFlashAttribute("message", "Could not found that order in your orders history");
			return "redirect:/orders";
		}
		model.addAttribute("order", order);
		return "order";
	}
}
