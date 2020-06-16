package uk.co.meridenspares.persistence.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import uk.co.meridenspares.persistence.dao.api.GenericDao;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

public class GenericDaoHibernate<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {

	private final Logger log = Logger.getLogger(GenericDaoHibernate.class);
	
	/** The type of object to persist */
	private final Class<T> persistentClass;
	
	/**
	 * Constructor - initialises the DAO
	 * @Param persistentClass - the type of object to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		Validate.notNull(persistentClass, "persistentClass cannot be null");
		this.persistentClass = persistentClass;
	}
	
	/**
	 * Get an object based on identifier.
	 * @param id - identifier (primary key) of the object to get
	 * @return populated object
	 * @throws DaoException
	 */
	public T get(final PK id) throws DaoException {
		Validate.notNull(id, "id cannot be null");		//TODO consider using DaoUtil to throw DaoException?
		
		try {
			final T entity = (T) getHibernateTemplate().get(persistentClass, id);
			
			if (entity == null) {
				log.warn("[" + persistentClass + "] object with ID [" + id +"] not found");
				throw new ObjectRetrievalFailureException(persistentClass, id);
											//TODO unchecked exception here?
			}
			
			return entity;
		}
		catch (HibernateException e) {
			String message = "Failed to get entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to get entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Returns a list of populated objects representing all the rows in the database corresponding to the
	 * instantiated type.
	 * @return List of populated objects
	 * @throws DaoException
	 */
	public List<T> getAll() throws DaoException {
		try {
			final List<T> entities = getHibernateTemplate().loadAll(persistentClass);
			getHibernateTemplate().getSessionFactory().getStatistics().logSummary();	//TODO needed?
			return entities;
		}
		catch (HibernateException e) {
			String message = "Failed to get all entities of type [" + persistentClass.getName() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to get all entities of type [" + persistentClass.getName() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Returns all records without duplicates.
	 * Note that if you use this method it is imperative that the model classes correctly implement the
	 * equals/hashCode methods.
	 * @return List of distinct populated objects
	 * @throws DaoException
	 */
	public List<T> getAllDistinct() throws DaoException {
		final Collection<T> entities = new LinkedHashSet<T>(getAll());	//TODO check this
		return new ArrayList<T>(entities);
	}

	/**
	 * Generic method to load an object from the persistence context. If the object is NOT in the persistence
	 * context then a proxy will be returned.
	 * This method should only be used for loading entities that are to be assigned as references to other
	 * entities but not actually used.
	 * @param id - identifier (primary key) of the object to get
	 * @return populated object
	 * @throws DaoException
	 */
	public T load(PK id) throws DaoException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			final T entity = (T) getHibernateTemplate().load(persistentClass, id);
			return entity;
		}
		catch (HibernateException e) {
			String message = "Failed to load entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to load entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Saves an object - handles both update and insert.
	 * @param object - the object to persist
	 * @return the persisted object
	 * @throws DaoException
	 */
	public T save(final T object) throws DaoException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			final T entity = (T) getHibernateTemplate().merge(object);	//TODO why not save or saveOrUpdate?
			flush();
			return entity;
		}
		catch (HibernateException e) {
			String message = "Failed to save entity of type [" + persistentClass.getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to save entity of type [" + persistentClass.getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Removes an object based on id.
	 * @param id - identifier (primary key) of the object to remove
	 * @throws DaoException
	 */
	public void remove(final PK id) throws DaoException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			getHibernateTemplate().delete(this.get(id));
		}
		catch (HibernateException e) {
			String message = "Failed to remove entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to remove entity of type [" + persistentClass.getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Deletes an object.
	 * @param object - the object to remove
	 * @throws DaoException
	 */
	public void remove(final T object) throws DaoException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			getHibernateTemplate().delete(object);
		}
		catch (HibernateException e) {
			String message = "Failed to remove entity of type [" + persistentClass.getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
		catch (DataAccessException e) {
			String message = "Failed to remove entity of type [" + persistentClass.getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new DaoException(message, e);
		}
	}

	/**
	 * Checks for the existence of an object of type T using the id argument.
	 * @param id - identifier (primary key) of the object to check
	 * @return true if object exists, false otherwise
	 * @throws DaoException
	 */
	public boolean exists(final PK id) throws DaoException {
		Validate.notNull(id, "id cannot be null");
		final T entity = get(id);
		return entity != null;
	}

	/**
	 * Initialises an object.
	 * @param object - the object to initialise
	 */
	public void initialise(final Object object) {
		Validate.notNull(object, "object cannot be null");
		getHibernateTemplate().initialize(object);
	}

	/**
	 * Flushes all changes to the database immediately.
	 */
	public void flush() {
		getHibernateTemplate().flush();
	}

	/**
	 * Evicts an object from the persistence context.
	 * @param object - the object to evict
	 * @throws DaoException
	 */
	public void evict(final T object) throws DaoException {
		Validate.notNull(object, "object cannot be null");
		getSession().evict(object);
	}

	/**
	 * Returns a UID representing the current persistence session.
	 * @return UID representing the current persistence session.
	 */
	public long getSessionUid() {
		Session session = getSession();
		return session != null ? session.hashCode() : -1L;
	}
}
 