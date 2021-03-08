package com.bootshop.site.utils;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.bootshop.site.entities.Item;
import com.bootshop.site.entities.Order;
import com.bootshop.site.entities.OrderDetails;

@Component("calculateSubTotalUtil")
public class CaculateSubTotalUtil {
	public float caculateSubTotal(List<Item> items) {
		float subtotal = 0;
		for (Item item : items) {
			float total = (item.getQuantity() * (item.getProductsSizes().getProduct().getPrice()));
			subtotal += total;
		}
		return subtotal;
	}
	
	public float caculateSubTotal(Order orders) {
		float subtotal = 0;
		for (OrderDetails orderDetails : orders.getOrderDetailses()) {
			float total = orderDetails.getPrice();
			subtotal += total;
		}
		return subtotal;
	}
}
