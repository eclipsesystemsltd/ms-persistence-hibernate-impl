package uk.co.meridenspares.persistence.service.impl;

import uk.co.meridenspares.domain.TopicEntryAttachment;
import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.TopicEntryAttachmentDao;
import uk.co.meridenspares.persistence.hibernate.api.TopicEntryAttachmentPersistenceService;

/**
 * This class defines methods specific to the 'TopicEntryAttachment' persistence service.
 * @author user
 *
 */
public class TopicEntryAttachmentPersistenceServiceImpl extends GenericPersistenceServiceImpl<TopicEntryAttachment, Long> implements TopicEntryAttachmentPersistenceService {

	private TopicEntryAttachmentDao topicEntryAttachmentDao;
	
	/**
	 * Constructor.
	 * @param partDao
	 */
	public TopicEntryAttachmentPersistenceServiceImpl(TopicEntryAttachmentDao topicEntryAttachmentDao) {
		super(topicEntryAttachmentDao);
		this.topicEntryAttachmentDao = topicEntryAttachmentDao;
	}
	
	/**
	 * Returns number of TopicEntryAttachments with specified name.
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
