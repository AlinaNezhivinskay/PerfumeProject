package by.grsu.perfumesystem.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IUserDAO;
import by.grsu.perfumesystem.model.User;
import by.grsu.perfumesystem.model.User_;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	public User getUserByLogin(String login) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(User_.login), login));
		return session.createQuery(criteriaQuery).getSingleResult();
	}

}
