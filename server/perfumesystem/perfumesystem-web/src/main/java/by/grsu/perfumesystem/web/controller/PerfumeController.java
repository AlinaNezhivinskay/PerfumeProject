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

import by.grsu.perfumesystem.api.sevice.IPerfumeService;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.model.Perfume;
import by.grsu.perfumesystem.web.dto.PerfumeDto;
import by.grsu.perfumesystem.web.util.ImageConverter;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {

	@Autowired
	private IPerfumeService perfumeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<PerfumeDto> getPerfumes() {
		List<PerfumeDto> answer = null;
		try {
			answer = new ArrayList<PerfumeDto>();
			List<Perfume> perfumes = perfumeService.getAllPerfume();
			for (Perfume perfume : perfumes) {
				PerfumeDto dto = convertToDto(perfume);
				answer.add(dto);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public PerfumeDto getPerfume(@RequestParam Integer id) {
		PerfumeDto answer = null;
		try {
			answer = convertToDto(perfumeService.getPerfumeById(id));
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		return answer;
	}

	@RequestMapping(value = "/by_brand", method = RequestMethod.GET)
	public List<PerfumeDto> getPerfumesByBrand(@RequestParam Integer id) {
		List<PerfumeDto> answer = null;
		try {
			answer = new ArrayList<PerfumeDto>();
			List<Perfume> perfumes = perfumeService.getPerfumesByBrand(id);
			for (Perfume perfume : perfumes) {
				PerfumeDto dto = convertToDto(perfume);
				answer.add(dto);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/by_note", method = RequestMethod.GET)
	public List<PerfumeDto> getPerfumesByNote(@RequestParam Integer id) {
		List<PerfumeDto> answer = null;
		try {
			answer = new ArrayList<PerfumeDto>();
			List<Perfume> perfumes = perfumeService.getPerfumesByNote(id);
			for (Perfume perfume : perfumes) {
				PerfumeDto dto = convertToDto(perfume);
				answer.add(dto);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addPerfume(@RequestBody PerfumeDto dto) {
		try {

			Perfume perfume = new Perfume(dto.getName(), dto.getType(), dto.getBrand(), dto.getReleaseYear(),
					dto.getCondition(), dto.getNotePyramide());
			perfume.setImage(ImageConverter.convertToByte(dto.getImage()));
			perfumeService.addPerfume(perfume);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void removePerfume(@RequestBody Perfume perfume) {
		try {
			perfumeService.removePerfume(perfume);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updatePerfume(@RequestBody Perfume perfume) {
		try {
			perfumeService.updatePerfume(perfume);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/by_notes", method = RequestMethod.POST)
	public void getPerfumesByNotes(@RequestBody List<Note> notes) {
		List<PerfumeDto> answer = null;
		try {
			answer = new ArrayList<PerfumeDto>();
			List<Perfume> perfumes = perfumeService.getPerfumesByNotes(notes);
			for (Perfume perfume : perfumes) {
				PerfumeDto dto = convertToDto(perfume);
				answer.add(dto);
			}
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	private PerfumeDto convertToDto(Perfume perfume) {
		PerfumeDto dto = new PerfumeDto(perfume.getId(), perfume.getName(), perfume.getType(), perfume.getBrand(),
				perfume.getReleaseYear(), perfume.getCondition());
		dto.setImage(ImageConverter.convertToString(perfume.getImage()));
		dto.setNotePyramide(perfume.getNotePyramide());
		return dto;
	}
}
