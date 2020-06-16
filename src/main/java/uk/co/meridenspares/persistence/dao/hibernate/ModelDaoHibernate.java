package uk.co.meridenspares.persistence.dao.hibernate;

import java.util.List;

import uk.co.meridenspares.domain.Model;
import uk.co.meridenspares.persistence.dao.api.ModelDao;
import uk.co.meridenspares.persistence.dao.api.exception.DaoException;

public class ModelDaoHibernate extends GenericDaoHibernate<Model, Long> implements ModelDao {

	public ModelDaoHibernate()  {
		super(Model.class);
	}

	public List<Integer> getModelYears() throws DaoException {
		String queryString = "select distinct firstYear from Model";
		@SuppressWarnings("unchecked")
		List<Integer> years = (List<Integer>) getHibernateTemplate().find(queryString);
		return years;
	}

	public List<Model> getModelsForYear(int year) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
}
