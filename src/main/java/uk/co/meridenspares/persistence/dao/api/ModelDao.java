/**
 * 
 */
package uk.co.meridenspares.persistence.dao.api;

import java.util.List;

import uk.co.meridenspares.domain.Model;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

/**
 * This interface declares methods provided by the 'Model' DAO.
 * @author user
 *
 */
public interface ModelDao extends GenericDao<Model, Long> {

	List<Integer> getModelYears() throws DaoException;
	
	List<Model> getModelsForYear(int year) throws DaoException;
}
