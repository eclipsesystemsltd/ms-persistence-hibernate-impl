package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.Role;
import uk.co.meridenspares.persistence.dao.api.RoleDao;

public class RoleDaoHibernate extends GenericDaoHibernate<Role, Long> implements RoleDao {

	public RoleDaoHibernate()  {
		super(Role.class);
	}
}
