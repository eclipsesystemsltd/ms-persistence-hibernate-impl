package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicCategory;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicCategoryDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicCategoryPersistenceService;

/**
 * This class defines methods specific to the 'TopicCategory' persistence service.
 * @author user
 *
 */
public class TopicCategoryPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicCategory, Long> implements TopicCategoryPersistenceService {

	private TopicCategoryDao topicCategoryDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicCategoryPersistenceServiceImpl(TopicCategoryDao topicCategoryDao) {
		super(topicCategoryDao);
		this.topicCategoryDao = topicCategoryDao;
	}
	
	/**
	 * Returns number of TopicCategorys with specified name.
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
