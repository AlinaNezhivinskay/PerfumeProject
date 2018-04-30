package by.grsu.perfumesystem.api.sevice;

import java.util.List;

import by.grsu.perfumesystem.model.Note;

public interface INoteService {

	void addNote(Note note) throws Exception;

	void removeNote(Note note) throws Exception;

	void updateNote(Note note) throws Exception;

	List<Note> getAllNote() throws Exception;

	Note getNoteById(Integer id) throws Exception;

	List<Note> getNotesByNoteGroup(Integer noteGroupId) throws Exception;

}
