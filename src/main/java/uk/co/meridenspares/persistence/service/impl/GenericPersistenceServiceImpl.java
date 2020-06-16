package uk.co.meridenspares.persistence.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.GenericDao;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;
import uk.co.meridenspares.persistence.hibernate.api.GenericPersistenceService;

/**
 * This class defines some basic methods that will be included in all domain object persistence services
 * @author user
 *
 * @param <T>
 * @param <PK>
 */
public class GenericPersistenceServiceImpl <T, PK extends Serializable> implements GenericPersistenceService<T, PK> {

	protected Logger log = Logger.getLogger(this.getClass());
	
	private GenericDao<T, PK> genericDao;

	/**
	 * Default constructor to allow frameworks to reflectively instantiate.
	 */
	public GenericPersistenceServiceImpl() {
	}

	/**
	 * Constructor with GenericDao.
	 * @param genericDao
	 */
	public GenericPersistenceServiceImpl(GenericDao<T, PK> genericDao) {
		Validate.notNull(genericDao, "genericDao cannot be null");
		this.genericDao = genericDao;
	}

	/**
	 * Returns instantiated type with given id.
	 * @param id
	 * @return Populated object or null if not in database
	 * @throws PersistenceServiceException
	 */
	public T get(PK id) throws PersistenceServiceException {
		Validate.notNull(id, "id cannot be null");	//TODO consider PersistenceUtil check?
		
		try {
			return genericDao.get(id);
		}
		catch (DaoException e) {
			String message = "Failed to get entity from [" + genericDao.getClass().getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Returns all objects of instantiated type.
	 * @return List of instantiated objects
	 * @throws PersistenceServiceException
	 */
	public List<T> getAll() throws PersistenceServiceException {
		try {
			return genericDao.getAll();
		}
		catch (DaoException e) {
			String message = "Failed to get all entities from [" + genericDao.getClass().getName() + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Returns instantiated type with given id.
	 * This method will throw an exception if there is no row in the database corresponding to the id.
	 * The object returned may be a proxy.
	 * @param id
	 * @return
	 * @throws PersistenceServiceException
	 */
	public T load(PK id) throws PersistenceServiceException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			return genericDao.load(id);
		}
		catch (DaoException e) {
			String message = "Failed to load entity from [" + genericDao.getClass().getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Saves provided object to the database.
	 * @param object
	 * @return
	 * @throws PersistenceServiceException
	 */
	public T save(T object) throws PersistenceServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			return genericDao.save(object);
		}
		catch (DaoException e) {
			String message = "Failed to save entity using [" + genericDao.getClass().getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Removes row corresponding to id from database.
	 * @param id
	 * @throws PersistenceServiceException
	 */
	public void remove(PK id) throws PersistenceServiceException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			genericDao.remove(id);
		}
		catch (DaoException e) {
			String message = "Failed to remove entity from [" + genericDao.getClass().getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Removes row corresponding to object from database.
	 * @param object
	 * @throws PersistenceServiceException
	 */
	public void remove(T object) throws PersistenceServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			genericDao.remove(object);
		}
		catch (DaoException e) {
			String message = "Failed to remove entity using [" + genericDao.getClass().getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Determines if row corresponding to id exists in database.
	 * @param id
	 * @return
	 * @throws PersistenceServiceException
	 */
	public boolean exists(PK id) throws PersistenceServiceException {
		Validate.notNull(id, "id cannot be null");
		
		try {
			return genericDao.exists(id);
		}
		catch (DaoException e) {
			String message = "Failed to determine if entity exists from [" + genericDao.getClass().getName() + "] with ID [" + id + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Flushes the current state of persistent objects in the persistence session to the database.
	 */
	public void flush() {
		genericDao.flush();
	}

	/**
	 * Evicts the object from the current persistence session.
	 * @param object
	 * @throws PersistenceServiceException
	 */
	public void evict(T object) throws PersistenceServiceException {
		Validate.notNull(object, "object cannot be null");
		
		try {
			genericDao.evict(object);
		}
		catch (DaoException e) {
			String message = "Failed to evict entity using [" + genericDao.getClass().getName() + "] [" + object.toString() + "]";
			log.warn(message);
			throw new PersistenceServiceException(message, e);
		}
	}

	/**
	 * Forces initialisation of a Hibernate or persistent collection.
	 * @param obj
	 */
	public void initialise(Object object) {
		Validate.notNull(object, "object cannot be null");
		genericDao.initialise(object);
	}

	/**
	 * Returns a UID representing the current persistence session.
	 * @return
	 * @throws PersistenceServiceException
	 */
	public long getSessionUid() throws PersistenceServiceException {
		return genericDao.getSessionUid();
	}
}
