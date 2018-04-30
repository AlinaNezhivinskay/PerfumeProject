package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grsu.perfumesystem.api.sevice.INoteGroupService;
import by.grsu.perfumesystem.model.NoteGroup;

@RestController
@RequestMapping("/note_group")
public class NoteGroupController {

	@Autowired
	private INoteGroupService noteGroupService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<NoteGroup> getNoteGroups() {
		List<NoteGroup> answer = null;
		try {
			answer = noteGroupService.getAllNoteGroup();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public NoteGroup getNoteGroup(@RequestParam Integer id) {
		NoteGroup answer = null;
		try {
			answer = noteGroupService.getNoteGroupById(id);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		return answer;
	}
}
