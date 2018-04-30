package by.grsu.perfumesystem.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

	private final Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void create(T object) throws Exception {
		getCurrentSession().save(object);
	}

	public T getById(Integer key) throws Exception {
		return (T) getCurrentSession().get(clazz, key);

	}

	public void update(T object) throws Exception {
		getCurrentSession().update(object);
	}

	public void saveOrUpdate(T object) throws Exception {
		getCurrentSession().saveOrUpdate(object);
	}

	public void delete(T object) throws Exception {
		getCurrentSession().delete(object);
	}

	public List<T> getAll() throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder criteriaBulder = session.getCriteriaBuilder();
		CriteriaQuery<T> sriteriaQuery = criteriaBulder.createQuery(clazz);
		Root<T> root = sriteriaQuery.from(clazz);
		sriteriaQuery.select(root);
		Query<T> query = session.createQuery(sriteriaQuery);
		return query.getResultList();
	}

}
