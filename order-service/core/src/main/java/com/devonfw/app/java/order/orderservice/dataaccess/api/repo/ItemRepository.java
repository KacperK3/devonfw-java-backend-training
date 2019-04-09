package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.devonfw.app.java.order.orderservice.common.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import static com.querydsl.core.alias.Alias.$;

import java.util.Set;

public interface ItemRepository extends DefaultRepository<ItemEntity> {

	default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

		  ItemEntity alias = newDslAlias();
		  JPAQuery<ItemEntity> query = newDslQuery(alias);

		  String name = criteria.getName();
		  if (name != null && !name.isEmpty()) {
		    QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		  }

		  // TODO: implement also expression for description and price
		  String description = criteria.getDescription();
		  if (description != null && !description.isEmpty()) {
			  QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
		  }

		  Double price = criteria.getPrice();
		  if (price != null) {
			  query.where($(alias.getPrice()).eq(price));
		  }

		  // TODO: implement also sorting using addOrderBy
		  query.orderBy($(alias.getPrice()).asc());

		  // TODO: return found items using QueryUtil
		  return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
		}

//	@Query(value = "SELECT FROM item WHERE name = :name")
	//public Set<ItemEntity> findByName(String name);

}
