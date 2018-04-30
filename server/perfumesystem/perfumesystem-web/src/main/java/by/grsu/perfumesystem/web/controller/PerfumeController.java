package by.grsu.perfumesystem.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grsu.perfumesystem.api.sevice.IPerfumeService;
import by.grsu.perfumesystem.model.Perfume;
import by.grsu.perfumesystem.web.dto.PerfumeDto;

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

	private PerfumeDto convertToDto(Perfume perfume) {
		PerfumeDto dto = new PerfumeDto(perfume.getId(), perfume.getName(), perfume.getType(), perfume.getBrand(),
				perfume.getReleaseYear(), perfume.getCondition());
		dto.setImage(perfume.getImage());
		return dto;
	}
}
