package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.List;
import java.util.Set;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcFindItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;

@Named
@Validated
@Transactional
public class UcFindItemImpl extends AbstractItemUc implements UcFindItem {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

	@Override
	public ItemEto findItem(long id) {
		LOG.debug("Get Item with id {} from database.", id);
		ItemEntity foundEntity = getItemRepository().getOne(id);
		return getBeanMapper().map(foundEntity, ItemEto.class);
	}

	@Override
	public Page<ItemEto> findItems(ItemSearchCriteriaTo criteria) {
		Page<ItemEntity> foundEntitys = getItemRepository().findByCriteria(criteria);
		List<ItemEntity> listItemEntity = foundEntitys.getContent();
		List<ItemEto> listItemEto = getBeanMapper().mapList(listItemEntity, ItemEto.class);
		return new PageImpl<>(listItemEto , foundEntitys.getPageable(), listItemEto.size());
	}

	@Override
	public Set<ItemEto> findItemsByName(String name) {
		Set<ItemEntity> foundEntitys = getItemRepository().findByName(name);
		return getBeanMapper().mapSet(foundEntitys, ItemEto.class);
	}

}
