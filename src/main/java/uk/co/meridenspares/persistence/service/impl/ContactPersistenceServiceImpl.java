package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.Contact;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.ContactDao;
import uk.co.meridenspares.persistence.hibernate.api.ContactPersistenceService;

/**
 * This class defines methods specific to the 'Contact' persistence service.
 * @author user
 *
 */
public class ContactPersistenceServiceImpl extends GenericPersistenceServiceImpl<Contact, Long> implements ContactPersistenceService {

	private ContactDao contactDao;
	
	/**
	 * Constructor.
	 * @param contactDao
	 */
	public ContactPersistenceServiceImpl(ContactDao contactDao) {
		super(contactDao);
		this.contactDao = contactDao;
	}
	
	/**
	 * Returns number of Contacts with specified name.
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
