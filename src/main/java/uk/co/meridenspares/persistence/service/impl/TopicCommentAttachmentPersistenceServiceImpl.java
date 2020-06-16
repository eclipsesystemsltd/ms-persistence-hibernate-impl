package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicCommentAttachment;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicCommentAttachmentDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicCommentAttachmentPersistenceService;

/**
 * This class defines methods specific to the 'TopicCommentAttachment' persistence service.
 * @author user
 *
 */
public class TopicCommentAttachmentPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicCommentAttachment, Long> implements TopicCommentAttachmentPersistenceService {

	private TopicCommentAttachmentDao topicCommentAttachmentDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicCommentAttachmentPersistenceServiceImpl(TopicCommentAttachmentDao topicCommentAttachmentDao) {
		super(topicCommentAttachmentDao);
		this.topicCommentAttachmentDao = topicCommentAttachmentDao;
	}
	
	/**
	 * Returns number of TopicCommentAttachments with specified name.
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
