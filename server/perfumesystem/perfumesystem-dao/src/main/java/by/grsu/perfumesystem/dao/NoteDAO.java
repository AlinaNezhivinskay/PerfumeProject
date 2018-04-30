package by.grsu.perfumesystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.INoteDAO;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.model.NoteGroup_;
import by.grsu.perfumesystem.model.Note_;

@Repository
public class NoteDAO extends AbstractDAO<Note> implements INoteDAO {

	public List<Note> getNotesByNoteGroup(Integer noteGroupId) throws Exception {
		Session session = getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Note> criteriaQuery = cb.createQuery(Note.class);
		Root<Note> root = criteriaQuery.from(Note.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Note_.group).get(NoteGroup_.id), noteGroupId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
