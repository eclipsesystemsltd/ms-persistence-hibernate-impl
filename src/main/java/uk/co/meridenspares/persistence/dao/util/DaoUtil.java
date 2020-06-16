package uk.co.meridenspares.persistence.dao.util;

import org.apache.commons.lang.Validate;

import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

/**
 * This class contains some simple methods to validate methods input, e.g. null checking.
 * @author user
 *
 */
public class DaoUtil {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private DaoUtil() {
	}
	
	/**
	 * Checks whether an object is null, if it is an exception is thrown.
	 * @param entity
	 * @param name
	 * @throws DaoException
	 */
	public static void nullCheck(final Object entity, final String name) throws DaoException {
		try {
			Validate.notNull(entity, name);
		}
		catch (IllegalArgumentException e) {
			throw new DaoException(e.getMessage());
		}
	}

}
