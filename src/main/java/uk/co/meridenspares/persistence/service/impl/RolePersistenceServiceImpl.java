package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.Role;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.RoleDao;
import uk.co.meridenspares.persistence.hibernate.api.RolePersistenceService;

/**
 * This class defines methods specific to the 'Role' persistence service.
 * @author user
 *
 */
public class RolePersistenceServiceImpl extends GenericPersistenceServiceImpl<Role, Long> implements RolePersistenceService {

	private RoleDao roleDao;
	
	/**
	 * Constructor.
	 * @param roleDao
	 */
	public RolePersistenceServiceImpl(RoleDao roleDao) {
		super(roleDao);
		this.roleDao = roleDao;
	}
	
	/**
	 * Returns number of Roles with specified name.
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
