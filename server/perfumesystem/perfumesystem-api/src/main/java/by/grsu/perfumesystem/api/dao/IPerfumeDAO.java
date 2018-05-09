package by.grsu.perfumesystem.api.dao;

import java.util.List;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;
import by.grsu.perfumesystem.model.Note;
import by.grsu.perfumesystem.model.Perfume;

public interface IPerfumeDAO extends GenericDAO<Perfume> {

	List<Perfume> getParfumesByBrand(Integer brandId) throws Exception;
	
	List<Perfume> getParfumesByNote(Integer noteId) throws Exception;
	
	List<Perfume> getParfumesByNotes(List<Note> notes) throws Exception;

}
