package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addNoteGroup(@RequestBody NoteGroup noteGroup) {
		try {
			noteGroupService.addNoteGroup(noteGroup);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void removeNote(@RequestBody NoteGroup noteGroup) {
		try {
			noteGroupService.removeNoteGroup(noteGroup);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}
}
