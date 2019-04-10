package com.devonfw.app.java.order.orderservice.logic.impl;

import java.time.LocalDate;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.general.logic.base.AbstractComponentFacade;
import com.devonfw.app.java.order.orderservice.common.api.OrderStatus;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindCustomer;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindItem;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindOrder;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageCustomer;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageOrder;

public class OrderserviceImpl extends AbstractComponentFacade implements Orderservice {

	@Inject
	private UcFindItem ucFindItem;

	@Inject
	private UcManageItem ucManageItem;

	@Inject
	private UcFindCustomer ucFindCustomer;

	@Inject
	private UcManageCustomer ucManageCustomer;

	@Inject
	private UcFindOrder ucFindOrder;

	@Inject
	private UcManageOrder ucManageOrder;

	@Override
	public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {
		return this.ucFindItem.findItems(criteria);
	}

	@Override
	public ItemEto findItem(long id) {

		return this.ucFindItem.findItem(id);
	}

	@Override
	public boolean deleteItem(long itemId) {

		return this.ucManageItem.deleteItem(itemId);
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		return this.saveItem(item);
	}

	@Override
	public CustomerEto findCustomer(long id) {

		return this.ucFindCustomer.findCustomer(id);
	}

	@Override
	public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {
		return this.ucFindCustomer.findCustomers(criteria);
	}

	@Override
	public CustomerEto saveCustomer(CustomerEto customer) {

		return this.ucManageCustomer.saveCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(long id) {

		return this.ucManageCustomer.deleteCustomer(id);
	}

	@Override
	public OrderEto findOrder(long id) {

		return this.ucFindOrder.findOrder(id);
	}

	@Override
	public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {
		return this.ucFindOrder.findOrders(criteria);
	}

	@Override
	public OrderEto saveOrder(OrderEto order) {

		return this.ucManageOrder.saveOrder(order);
	}

	@Override
	public boolean deleteOrder(long id) {

		return this.ucManageOrder.deleteOrder(id);
	}

	@Override
	public ItemEto increasePriceOfItem(String name) {

		return this.ucManageItem.increasePriceOfItem(name);
	}

	@Override
	public CustomerEto removeCustomer(long customerId) {

		return this.ucManageCustomer.removeCustomer(customerId);
	}

	@Override
	public OrderEto createOrder(ItemEto firstItem, ItemEto secondItem, CustomerEto customer) {

		return this.createOrder(firstItem, secondItem, customer);
	}

	@Override
	public Set<OrderEto> findOrdersFromDateWithStatus(LocalDate date, OrderStatus status) {

		return this.findOrdersFromDateWithStatus(date, status);
	}

	@Override
	public Set<ItemEto> findItemsByName(String name) {

		return this.ucFindItem.findItemsByName(name);
	}

}
