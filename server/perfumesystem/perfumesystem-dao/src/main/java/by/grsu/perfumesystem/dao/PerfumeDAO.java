package by.grsu.perfumesystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IPerfumeDAO;
import by.grsu.perfumesystem.model.Brand_;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.model.NotePyramide;
import by.grsu.perfumesystem.model.NotePyramide_;
import by.grsu.perfumesystem.model.Note_;
import by.grsu.perfumesystem.model.Perfume;
import by.grsu.perfumesystem.model.Perfume_;
import by.grsu.perfumesystem.model.util.PerfumePyramideType;

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

	public List<Perfume> getParfumesByNote(Integer noteId) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perfume> criteriaQuery = cb.createQuery(Perfume.class);
		Root<NotePyramide> root = criteriaQuery.from(NotePyramide.class);
		criteriaQuery.select(root.get(NotePyramide_.perfume));
		criteriaQuery.where(cb.and(cb.equal(root.get(NotePyramide_.note).get(Note_.id), noteId),
				cb.equal(root.get(NotePyramide_.type), PerfumePyramideType.BASIC)));
		return session.createQuery(criteriaQuery).getResultList();
	}

	public List<Perfume> getParfumesByNotes(List<Note> notes) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Perfume> criteriaQuery = cb.createQuery(Perfume.class);
		Root<NotePyramide> root = criteriaQuery.from(NotePyramide.class);
		criteriaQuery.select(root.get(NotePyramide_.perfume));

		Predicate[] predicates = new Predicate[notes.size()];
		int i = 0;
		for (Note note : notes) {
			predicates[i] = cb.and(cb.equal(root.get(NotePyramide_.note).get(Note_.id), note.getId()),
					cb.equal(root.get(NotePyramide_.type), PerfumePyramideType.BASIC));
			i++;
		}

		criteriaQuery.where(cb.or(predicates));

		return session.createQuery(criteriaQuery).getResultList();
	}
}
