package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicComment;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicCommentDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicCommentPersistenceService;

/**
 * This class defines methods specific to the 'TopicComment' persistence service.
 * @author user
 *
 */
public class TopicCommentPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicComment, Long> implements TopicCommentPersistenceService {

	private TopicCommentDao topicCommentDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicCommentPersistenceServiceImpl(TopicCommentDao topicCommentDao) {
		super(topicCommentDao);
		this.topicCommentDao = topicCommentDao;
	}
	
	/**
	 * Returns number of TopicComments with specified name.
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
