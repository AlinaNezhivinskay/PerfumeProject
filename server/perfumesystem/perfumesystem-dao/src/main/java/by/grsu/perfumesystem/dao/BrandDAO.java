package by.grsu.perfumesystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IBrandDAO;
import by.grsu.perfumesystem.model.Brand;
import by.grsu.perfumesystem.model.Brand_;
import by.grsu.perfumesystem.model.Country_;

@Repository
public class BrandDAO extends AbstractDAO<Brand> implements IBrandDAO {

	public List<Brand> getBrandsByCountry(Integer countryId) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Brand> criteriaQuery = cb.createQuery(Brand.class);
		Root<Brand> root = criteriaQuery.from(Brand.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Brand_.country).get(Country_.id), countryId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
