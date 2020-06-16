package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicComment;
import uk.co.meridenspares.persistence.dao.api.TopicCommentDao;

public class TopicCommentDaoHibernate extends GenericDaoHibernate<TopicComment, Long> implements TopicCommentDao {

	public TopicCommentDaoHibernate()  {
		super(TopicComment.class);
	}
}
