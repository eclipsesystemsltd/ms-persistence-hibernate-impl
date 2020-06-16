package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicCategory;
import uk.co.meridenspares.persistence.dao.api.TopicCategoryDao;

public class TopicCategoryDaoHibernate extends GenericDaoHibernate<TopicCategory, Long> implements TopicCategoryDao {

	public TopicCategoryDaoHibernate()  {
		super(TopicCategory.class);
	}
}
