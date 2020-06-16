package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicCommentAttachment;
import uk.co.meridenspares.persistence.dao.api.TopicCommentAttachmentDao;

public class TopicCommentAttachmentDaoHibernate extends GenericDaoHibernate<TopicCommentAttachment, Long> implements TopicCommentAttachmentDao {

	public TopicCommentAttachmentDaoHibernate()  {
		super(TopicCommentAttachment.class);
	}
}
