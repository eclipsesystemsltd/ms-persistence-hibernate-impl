package uk.co.meridenspares.persistence.dao.api;

import java.io.Serializable;
import java.util.List;

import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

/**
 * This interface declares generic methods provided by all DAOs.
 *
 * @author user
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Get an object based on identifier.
	 * @param id - identifier (primary key) of the object to get
	 * @return populated object
	 * @throws DaoException
	 */
	T get(PK id) throws DaoException;
	
	/**
	 * Returns a list of populated objects representing all the rows in the database corresponding to the
	 * instantiated type.
	 * @return List of populated objects
	 * @throws DaoException
	 */
	List<T> getAll() throws DaoException;
	
	/**
	 * Returns all records without duplicates.
	 * Note that if you use this method it is imperative that the model classes correctly implement the
	 * equals/hashCode methods.
	 * @return List of distinct populated objects
	 * @throws DaoException
	 */
	List<T> getAllDistinct() throws DaoException;
	
	/**
	 * Generic method to load an object from the persistence context. If the object is NOT in the persistence
	 * context then a proxy will be returned.
	 * This method should only be used for loading entities that are to be assigned as references to other
	 * entities but not actually used.
	 * @param id - identifier (primary key) of the object to get
	 * @return populated object
	 * @throws DaoException
	 */
	T load(PK id) throws DaoException;
	
	/**
	 * Saves an object - handles both update and insert.
	 * @param object - the object to persist
	 * @return the persisted object
	 * @throws DaoException
	 */
	T save(T object) throws DaoException;

	/**
	 * Removes an object based on id.
	 * @param id - identifier (primary key) of the object to remove
	 * @throws DaoException
	 */
	void remove(PK id) throws DaoException;

	/**
	 * Deletes an object.
	 * @param object - the object to remove
	 * @throws DaoException
	 */
	void remove(T object) throws DaoException;

	/**
	 * Checks for the existence of an object of type T using the id argument.
	 * @param id - identifier (primary key) of the object to check
	 * @return true if object exists, false otherwise
	 * @throws DaoException
	 */
	boolean exists(PK id) throws DaoException;

	/**
	 * Initialises an object.
	 * @param object - the object to initialise
	 */
	void initialise(Object object);
	
	/**
	 * Flushes all changes to the database immediately.
	 */
	void flush();
	
	/**
	 * Evicts an object from the persistence context.
	 * @param object - the object to evict
	 * @throws DaoException
	 */
	void evict(T object) throws DaoException;
	
	/**
	 * Returns a UID representing the current persistence session.
	 * @return UID representing the current persistence session.
	 */
	long getSessionUid();
	
}
