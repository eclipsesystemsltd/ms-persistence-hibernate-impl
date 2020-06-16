/**
 * 
 */
package uk.co.meridenspares.persistence.dao.hibernate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import uk.co.meridenspares.persistence.dao.api.ContactDao;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

/**
 * @author user
 *
 */
public class ContactDaoHibernateTest extends BaseDaoTestCase {
	
	@Autowired
	ContactDao contactDao;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
        ClassLoader loader = ContactDaoHibernateTest.class.getClassLoader();
        System.out.println("XXXXXX " + loader.getResource("org/apache/commons/logging/impl/SLF4JLocationAwareLog.class"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link uk.co.meridenspares.persistence.dao.hibernate.GenericDaoHibernate#get(java.io.Serializable)}.
	 * @throws DaoException 
	 */
	@Test
	@Transactional
	public void testGet() throws DaoException {
//		contactDao.get(1L);
		contactDao.getAll();
	}

	/**
	 * Test method for {@link uk.co.meridenspares.persistence.dao.hibernate.GenericDaoHibernate#getAll()}.
	 * @throws DaoException 
	 */
	@Test
	@Transactional
	public void testGetAll() throws DaoException {
		contactDao.getAll();
	}

	/**
	 * Test method for {@link uk.co.meridenspares.persistence.dao.hibernate.GenericDaoHibernate#load(java.io.Serializable)}.
	 */
	@Test
	@Transactional
	public void testLoad() {
//		fail("Not yet implemented");
	}

}
