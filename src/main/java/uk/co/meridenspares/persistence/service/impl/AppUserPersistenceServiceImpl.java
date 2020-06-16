package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.AppUser;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.AppUserDao;
import uk.co.meridenspares.persistence.hibernate.api.AppUserPersistenceService;

/**
 * This class defines methods specific to the 'AppUser' persistence service.
 * @author user
 *
 */
public class AppUserPersistenceServiceImpl extends GenericPersistenceServiceImpl<AppUser, Long> implements AppUserPersistenceService {

	private AppUserDao appUserDao;
	
	/**
	 * Constructor.
	 * @param appUserDao
	 */
	public AppUserPersistenceServiceImpl(AppUserDao appUserDao) {
		super(appUserDao);
		this.appUserDao = appUserDao;
	}
	
	/**
	 * Returns number of AppUsers with specified name.
	 * @param name
	 * @return
	 * @throws PersistenceServiceException
	 */
	public int getCountByName(String name) throws PersistenceServiceException {
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
