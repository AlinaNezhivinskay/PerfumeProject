package by.grsu.perfumesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grsu.perfumesystem.api.dao.INoteGroupDAO;
import by.grsu.perfumesystem.api.sevice.INoteGroupService;
import by.grsu.perfumesystem.model.NoteGroup;

@Service
@Transactional
public class NoteGroupService implements INoteGroupService {

	@Autowired
	private INoteGroupDAO noteGroupDAO;

	public void addNoteGroup(NoteGroup noteGroup) throws Exception {
		noteGroupDAO.create(noteGroup);

	}

	public void removeNoteGroup(NoteGroup noteGroup) throws Exception {
		noteGroupDAO.delete(noteGroup);

	}

	public void updateNoteGroup(NoteGroup noteGroup) throws Exception {
		noteGroupDAO.update(noteGroup);

	}

	public List<NoteGroup> getAllNoteGroup() throws Exception {
		return noteGroupDAO.getAll();
	}

	public NoteGroup getNoteGroupById(Integer id) throws Exception {
		return noteGroupDAO.getById(id);
	}

}
