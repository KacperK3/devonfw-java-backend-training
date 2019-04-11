package com.devonfw.app.java.order.orderservice.service.impl.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

/**
 * The service implementation for REST calls in order to execute the logic of
 * component {@link Orderservice}.
 */
@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

	@Inject
	private Orderservice orderservice;

	@Override
	public CustomerEto getCustomer(long id) {
		return this.orderservice.findCustomer(id);
	}

	@Override
	public CustomerEto saveCustomer(CustomerEto customer) {
		return this.orderservice.saveCustomer(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		this.orderservice.deleteCustomer(id);
	}

	@Override
	public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo searchCriteriaTo) {
		return this.orderservice.findCustomers(searchCriteriaTo);
	}

	@Override
	public Set<ItemEto> findItemByName(String name) {
		return this.orderservice.findByName(name);
	}

	@Override
	public OrderCto saveOrder(OrderCto order) {
		return this.orderservice.saveOrder(order);
	}

	@Override
	public ItemEto getItem(long id) {
		return this.orderservice.findItem(id);
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		return this.orderservice.saveItem(item);
	}

	@Override
	public void deleteItem(long id) {
		this.orderservice.deleteItem(id);
	}

	@Override
	public Page<ItemEto> findItems(ItemSearchCriteriaTo searchCriteriaTo) {
		return this.orderservice.findItems(searchCriteriaTo);
	}

}
