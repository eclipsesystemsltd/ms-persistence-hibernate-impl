package uk.co.meridenspares.persistence.service.impl.util;

import org.apache.commons.lang.Validate;

import uk.co.meridenspares.persistence.api.exception.PersistenceServiceException;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

/**
 * This class contains some simple methods to validate methods input, e.g. null checking.
 * @author user
 *
 */
public class PersistenceUtil {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private PersistenceUtil() {
	}
	
	/**
	 * Checks whether an object is null, if it is an exception is thrown.
	 * @param entity
	 * @param name
	 * @throws DaoException
	 */
	public static void nullCheck(final Object entity, final String name) throws PersistenceServiceException {
		try {
			Validate.notNull(entity, name);
		}
		catch (IllegalArgumentException e) {
			throw new PersistenceServiceException(e.getMessage());
		}
	}

}
