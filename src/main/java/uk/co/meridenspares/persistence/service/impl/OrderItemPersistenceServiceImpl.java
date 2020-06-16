package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.OrderItem;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.OrderItemDao;
import uk.co.meridenspares.persistence.hibernate.api.OrderItemPersistenceService;

/**
 * This class defines methods specific to the 'OrderItem' persistence service.
 * @author user
 *
 */
public class OrderItemPersistenceServiceImpl extends GenericPersistenceServiceImpl<OrderItem, Long> implements OrderItemPersistenceService {

	private OrderItemDao orderItemDao;
	
	/**
	 * Constructor.
	 * @param orderItemDao
	 */
	public OrderItemPersistenceServiceImpl(OrderItemDao orderItemDao) {
		super(orderItemDao);
		this.orderItemDao = orderItemDao;
	}
	
	/**
	 * Returns number of OrderItems with specified name.
	 * @param name
	 * @return
	 * @throws PersistenceServiceException
	 */
	public Integer getCountByName(String name) throws PersistenceServiceException {
		/*
		try {
			return appUserDao.getCountByName(name);
		}
		catch (DaoException e) {
			String message = "Unable to get count by name for name [" + name + "]";
			throw new PersistenceServiceException(message, e);
		}
		*/
		return 0;	//TODO
	}

}
