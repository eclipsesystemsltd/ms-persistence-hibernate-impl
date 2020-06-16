package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicAttachment;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicAttachmentDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicAttachmentPersistenceService;

/**
 * This class defines methods specific to the 'TopicAttachment' persistence service.
 * @author user
 *
 */
public class TopicAttachmentPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicAttachment, Long> implements TopicAttachmentPersistenceService {

	private TopicAttachmentDao topicAttachmentDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicAttachmentPersistenceServiceImpl(TopicAttachmentDao topicAttachmentDao) {
		super(topicAttachmentDao);
		this.topicAttachmentDao = topicAttachmentDao;
	}
	
	/**
	 * Returns number of TopicAttachments with specified name.
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
