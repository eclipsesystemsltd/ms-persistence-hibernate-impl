package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicEntry;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicEntryDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicEntryPersistenceService;

/**
 * This class defines methods specific to the 'TopicEntry' persistence service.
 * @author user
 *
 */
public class TopicEntryPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicEntry, Long> implements TopicEntryPersistenceService {

	private TopicEntryDao topicEntryDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicEntryPersistenceServiceImpl(TopicEntryDao topicEntryDao) {
		super(topicEntryDao);
		this.topicEntryDao = topicEntryDao;
	}
	
	/**
	 * Returns number of TopicEntrys with specified name.
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
