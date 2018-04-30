package by.grsu.perfumesystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IPerfumeDAO;
import by.grsu.perfumesystem.model.Brand_;
import by.grsu.perfumesystem.model.Perfume;
import by.grsu.perfumesystem.model.Perfume_;

@Repository
public class PerfumeDAO extends AbstractDAO<Perfume> implements IPerfumeDAO {

	public List<Perfume> getParfumesByBrand(Integer brandId) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perfume> criteriaQuery = cb.createQuery(Perfume.class);
		Root<Perfume> root = criteriaQuery.from(Perfume.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Perfume_.brand).get(Brand_.id), brandId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
