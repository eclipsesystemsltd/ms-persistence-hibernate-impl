package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.TopicEntry;
import uk.co.meridenspares.persistence.dao.api.TopicEntryDao;


public class TopicEntryDaoHibernate extends GenericDaoHibernate<TopicEntry, Long> implements TopicEntryDao {

	public TopicEntryDaoHibernate()  {
		super(TopicEntry.class);
	}
}
