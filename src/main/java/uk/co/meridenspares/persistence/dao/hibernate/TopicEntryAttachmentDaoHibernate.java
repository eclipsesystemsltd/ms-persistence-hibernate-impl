package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicEntryAttachment;
import uk.co.meridenspares.persistence.dao.api.TopicEntryAttachmentDao;


public class TopicEntryAttachmentDaoHibernate extends GenericDaoHibernate<TopicEntryAttachment, Long> implements TopicEntryAttachmentDao {

	public TopicEntryAttachmentDaoHibernate()  {
		super(TopicEntryAttachment.class);
	}
}
