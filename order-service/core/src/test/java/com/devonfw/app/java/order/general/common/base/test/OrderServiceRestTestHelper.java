package com.devonfw.app.java.order.general.common.base.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.devonfw.app.java.order.orderservice.common.base.CustomerTestData;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderTestData;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;

public class OrderServiceRestTestHelper {

	public OrderCto createDummyOrderCTO() {

		CustomerEto owner = CustomerTestData.MICKEY_MOUSE.build();
		Set<ItemEto> orderPositions = new HashSet<>();
		orderPositions.add(ItemTestData.CORN.build());
		OrderEto order = OrderTestData.ORDER_NEW.build();
		order.setOwnerId(owner.getId());
		OrderCto orderCto = new OrderCto();
		orderCto.setOrderPositions(orderPositions);
		orderCto.setOrder(order);
		orderCto.setOwner(owner);
		return orderCto;
	}

}
