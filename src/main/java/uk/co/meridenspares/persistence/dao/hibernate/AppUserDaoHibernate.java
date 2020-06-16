package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.AppUser;
import uk.co.meridenspares.persistence.dao.api.AppUserDao;

public class AppUserDaoHibernate extends GenericDaoHibernate<AppUser, Long> implements AppUserDao {

	public AppUserDaoHibernate()  {
		super(AppUser.class);
	}
}
