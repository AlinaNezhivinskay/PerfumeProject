package by.grsu.perfumesystem.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grsu.perfumesystem.api.sevice.INoteService;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.web.dto.NoteDto;
import by.grsu.perfumesystem.web.util.ImageConverter;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	private INoteService noteService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<NoteDto> getNotes() {
		List<NoteDto> answer = null;
		try {
			answer = new ArrayList<NoteDto>();
			List<Note> notes = noteService.getAllNote();
			for (Note note : notes) {
				NoteDto dto = convertToDto(note);
				answer.add(dto);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public NoteDto getNote(@RequestParam Integer id) {
		NoteDto answer = null;
		try {
			answer = convertToDto(noteService.getNoteById(id));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		return answer;
	}

	@RequestMapping(value = "/by_note_group", method = RequestMethod.GET)
	public List<Note> getNotesByNoteGroup(@RequestParam Integer id) {
		List<Note> answer = null;
		try {
			answer = noteService.getNotesByNoteGroup(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addNote(@RequestBody NoteDto dto) {
		try {

			Note note = new Note(dto.getName(), dto.getGroup());
			note.setImage(ImageConverter.convertToByte(dto.getImage()));
			noteService.addNote(note);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void removeNote(@RequestBody Note note) {
		try {
			noteService.removeNote(note);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	private NoteDto convertToDto(Note note) {
		NoteDto dto = new NoteDto(note.getId(), note.getName(), note.getGroup());
		dto.setImage(note.getImage());
		return dto;
	}
}
