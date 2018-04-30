package by.grsu.perfumesystem.api.sevice;

import java.util.List;

import by.grsu.perfumesystem.model.NoteGroup;

public interface INoteGroupService {

	void addNoteGroup(NoteGroup noteGroup) throws Exception;

	void removeNoteGroup(NoteGroup noteGroup) throws Exception;

	void updateNoteGroup(NoteGroup noteGroup) throws Exception;

	List<NoteGroup> getAllNoteGroup() throws Exception;

	NoteGroup getNoteGroupById(Integer id) throws Exception;
}
