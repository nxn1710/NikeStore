package com.bootshop.site.entities;

import com.bootshop.site.exceptions.QuantityOutOfStock;

public class Item {
	private ProductsSizes productsSizes;
	private Integer quantity;
	
	
	public Item() {
		
	}
	
	public Item(ProductsSizes productsSizes, Integer quantity) throws QuantityOutOfStock {
		super();
		this.productsSizes = productsSizes;
		if (quantity <= productsSizes.getQuantity()) {
			this.quantity = quantity;
		} else {
			quantity = 0;
			throw new QuantityOutOfStock("Quantity out of stock");
		}
	}

	public ProductsSizes getProductsSizes() {
		return productsSizes;
	}
	public void setProductsSizes(ProductsSizes productsSizes) {
		this.productsSizes = productsSizes;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) throws QuantityOutOfStock {
		if (quantity <= productsSizes.getQuantity()) {
			this.quantity = quantity;
		} else {
			quantity = 0;
			throw new QuantityOutOfStock("Quantity out of stock");
		}
	}

	@Override
	public String toString() {
		return "Item [productsSizes=" + productsSizes + ", quantity=" + quantity + "]";
	}
	
	
}
