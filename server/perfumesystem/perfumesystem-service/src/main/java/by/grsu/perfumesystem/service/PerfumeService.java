package by.grsu.perfumesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grsu.perfumesystem.api.dao.INotePyramideDAO;
import by.grsu.perfumesystem.api.dao.IPerfumeConditionDAO;
import by.grsu.perfumesystem.api.dao.IPerfumeDAO;
import by.grsu.perfumesystem.api.sevice.IPerfumeService;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.model.NotePyramide;
import by.grsu.perfumesystem.model.Perfume;

@Service
@Transactional
public class PerfumeService implements IPerfumeService {

	@Autowired
	private IPerfumeDAO perfumeDAO;

	@Autowired
	private INotePyramideDAO notePyramideDAO;

	@Autowired
	private IPerfumeConditionDAO perfumeConditionDAO;

	public void addPerfume(Perfume perfume) throws Exception {
		perfumeConditionDAO.create(perfume.getCondition());
		perfumeDAO.create(perfume);
		for (NotePyramide notePyramide : perfume.getNotePyramide()) {
			notePyramide.setPerfume(perfume);
			notePyramideDAO.create(notePyramide);
		}
	}

	public void removePerfume(Perfume perfume) throws Exception {
		perfumeDAO.delete(perfume);
	}

	public void updatePerfume(Perfume perfume) throws Exception {
		perfumeDAO.update(perfume);
	}

	public List<Perfume> getAllPerfume() throws Exception {
		return perfumeDAO.getAll();
	}

	public Perfume getPerfumeById(Integer id) throws Exception {
		Perfume perfume = perfumeDAO.getById(id);
		perfume.getNotePyramide().size();
		return perfume;
	}

	public List<Perfume> getPerfumesByBrand(Integer brandId) throws Exception {
		return perfumeDAO.getParfumesByBrand(brandId);
	}

	public List<Perfume> getPerfumesByNote(Integer noteId) throws Exception {
		return perfumeDAO.getParfumesByNote(noteId);
	}

	public List<Perfume> getPerfumesByNotes(List<Note> notes) throws Exception {
		return perfumeDAO.getParfumesByNotes(notes);
	}
}
