package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;

import com.devonfw.app.java.order.orderservice.common.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest {

	@Inject
	private ItemRepository itemRepository;

	@Test
	public void shouldFindAllItems() {
		// when
		List<ItemEntity> foundItems = itemRepository.findAll();

		// then
		assertThat(foundItems).hasSize(1);
	}

	@Test
	public void shouldFindByCriteria() {
		// when
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setDescription("Italy");
		criteria.setPageable(new QPageRequest(0,5));

		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems).hasSize(1);
	}
	@Test
	public void shouldFindByPrice() {
		// when
		ItemSearchCriteriaTo criteria = new ItemSearchCriteriaTo();
		criteria.setPrice(250.0);
		Sort sort = Sort.by("price");
		Pageable pageable = PageRequest.of(0, 20, sort);
		criteria.setPageable(pageable);


		Page<ItemEntity> foundItems = itemRepository.findByCriteria(criteria);

		// then
		assertThat(foundItems).hasSize(1);
	}
}
