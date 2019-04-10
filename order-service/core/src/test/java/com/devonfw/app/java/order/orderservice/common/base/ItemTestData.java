package com.devonfw.app.java.order.orderservice.common.base;

import com.devonfw.app.java.order.common.builders.ItemEtoBuilder;

public interface ItemTestData {

	/**
	   * The constant CHEESE.
	   */
	  ItemEtoBuilder CHEESE = new ItemEtoBuilder()
	      .name("cheese")
	      .price(12.50);

}
