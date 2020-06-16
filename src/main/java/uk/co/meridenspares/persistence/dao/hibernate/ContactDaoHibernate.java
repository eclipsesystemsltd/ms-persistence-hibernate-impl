package uk.co.meridenspares.persistence.dao.hibernate;

import uk.co.meridenspares.domain.Contact;
import uk.co.meridenspares.persistence.dao.api.ContactDao;

public class ContactDaoHibernate extends GenericDaoHibernate<Contact, Long> implements ContactDao {

	public ContactDaoHibernate()  {
		super(Contact.class);
	}
}
