package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.CustomerOrder;
import uk.co.meridenspares.persistence.dao.api.CustomerOrderDao;

public class CustomerOrderDaoHibernate extends GenericDaoHibernate<CustomerOrder, Long> implements CustomerOrderDao {

	public CustomerOrderDaoHibernate()  {
		super(CustomerOrder.class);
	}
}
