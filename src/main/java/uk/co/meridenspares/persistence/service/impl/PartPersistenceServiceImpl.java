package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.Part;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.PartDao;
import uk.co.meridenspares.persistence.hibernate.api.PartPersistenceService;

/**
 * This class defines methods specific to the 'Part' persistence service.
 * @author user
 *
 */
public class PartPersistenceServiceImpl extends GenericPersistenceServiceImpl<Part, Long> implements PartPersistenceService {

	private PartDao partDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public PartPersistenceServiceImpl(PartDao partDao) {
		super(partDao);
		this.partDao = partDao;
	}
	
	/**
	 * Returns number of Parts with specified name.
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
