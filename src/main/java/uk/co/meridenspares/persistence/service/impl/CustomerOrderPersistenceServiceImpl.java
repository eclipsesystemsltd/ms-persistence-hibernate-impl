package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.CustomerOrder;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.CustomerOrderDao;
import uk.co.meridenspares.persistence.hibernate.api.CustomerOrderPersistenceService;

/**
 * This class defines methods specific to the 'CustomerOrder' persistence service.
 * @author user
 *
 */
public class CustomerOrderPersistenceServiceImpl extends GenericPersistenceServiceImpl<CustomerOrder, Long> implements CustomerOrderPersistenceService {

	private CustomerOrderDao customerOrderDao;
	
	/**
	 * Constructor.
	 * @param customerOrderDao
	 */
	public CustomerOrderPersistenceServiceImpl(CustomerOrderDao customerOrderDao) {
		super(customerOrderDao);
		this.customerOrderDao = customerOrderDao;
	}
	
	/**
	 * Returns number of CustomerOrders with specified name.
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
