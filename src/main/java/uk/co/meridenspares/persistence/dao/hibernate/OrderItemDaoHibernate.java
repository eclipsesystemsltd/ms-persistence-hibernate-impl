package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.OrderItem;
import uk.co.meridenspares.persistence.dao.api.OrderItemDao;

public class OrderItemDaoHibernate extends GenericDaoHibernate<OrderItem, Long> implements OrderItemDao {

	public OrderItemDaoHibernate()  {
		super(OrderItem.class);
	}
}
