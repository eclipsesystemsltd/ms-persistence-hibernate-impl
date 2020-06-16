package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicAttachment;
import uk.co.meridenspares.persistence.dao.api.TopicAttachmentDao;

public class TopicAttachmentDaoHibernate extends GenericDaoHibernate<TopicAttachment, Long> implements TopicAttachmentDao {

	public TopicAttachmentDaoHibernate()  {
		super(TopicAttachment.class);
	}
}
