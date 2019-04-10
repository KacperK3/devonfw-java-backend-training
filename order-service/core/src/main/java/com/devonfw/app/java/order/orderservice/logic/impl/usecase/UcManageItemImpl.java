package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import java.util.Objects;
import java.util.Set;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;

@Named
@Validated
@Transactional
public class UcManageItemImpl extends AbstractItemUc implements UcManageItem {

	/**
	 * Logger instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindItemImpl.class);

	@Override
	public boolean deleteItem(long itemId) {

		getItemRepository().deleteById(itemId);
		LOG.debug("Delete Item with id {} from database.", itemId);
		return true;
	}

	@Override
	public ItemEto saveItem(ItemEto item) {

		Objects.requireNonNull(item, "item must not be null");

		ItemEntity itemEntity = getBeanMapper().map(item, ItemEntity.class);
		ItemEntity savedItem= getItemRepository().save(itemEntity);
		LOG.debug("Item with id '{}' has been created.", savedItem.getId());
		return getBeanMapper().map(savedItem, ItemEto.class);
	}

	@Override
	public ItemEto increasePriceOfItem(String name) {
		Set<ItemEntity> foundEntity = getItemRepository().findByName(name);
		for (ItemEntity item : foundEntity) {
			item.setPrice(item.getPrice()+1);
		}
		return null;
	}

}
