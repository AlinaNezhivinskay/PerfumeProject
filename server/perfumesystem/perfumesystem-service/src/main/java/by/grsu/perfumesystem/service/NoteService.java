package by.grsu.perfumesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grsu.perfumesystem.api.dao.INoteDAO;
import by.grsu.perfumesystem.api.sevice.INoteService;
import by.grsu.perfumesystem.model.Note;

@Service
@Transactional
public class NoteService implements INoteService {

	@Autowired
	private INoteDAO noteDAO;

	public void addNote(Note note) throws Exception {
		noteDAO.create(note);

	}

	public void removeNote(Note note) throws Exception {
		noteDAO.delete(note);

	}

	public void updateNote(Note note) throws Exception {
		noteDAO.update(note);

	}

	public List<Note> getAllNote() throws Exception {
		return noteDAO.getAll();
	}

	public Note getNoteById(Integer id) throws Exception {
		return noteDAO.getById(id);
	}

	public List<Note> getNotesByNoteGroup(Integer noteGroupId) throws Exception {
		return noteDAO.getNotesByNoteGroup(noteGroupId);
	}

}
