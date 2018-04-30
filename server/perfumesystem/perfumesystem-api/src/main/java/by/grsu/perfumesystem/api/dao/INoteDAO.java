package by.grsu.perfumesystem.api.dao;

import java.util.List;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;
import by.grsu.perfumesystem.model.Note;

public interface INoteDAO extends GenericDAO<Note> {

	List<Note> getNotesByNoteGroup(Integer noteGroupId) throws Exception;
}
