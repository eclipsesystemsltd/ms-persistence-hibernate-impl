package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.Part;
import uk.co.meridenspares.persistence.dao.api.PartDao;

public class PartDaoHibernate extends GenericDaoHibernate<Part, Long> implements PartDao {

	public PartDaoHibernate()  {
		super(Part.class);
	}
}
