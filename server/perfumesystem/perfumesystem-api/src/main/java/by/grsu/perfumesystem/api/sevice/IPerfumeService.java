package by.grsu.perfumesystem.api.sevice;

import java.util.List;

import by.grsu.perfumesystem.model.Perfume;

public interface IPerfumeService {

	void addPerfume(Perfume perfume) throws Exception;

	void removePerfume(Perfume perfume) throws Exception;

	void updatePerfume(Perfume perfume) throws Exception;

	List<Perfume> getAllPerfume() throws Exception;

	Perfume getPerfumeById(Integer id) throws Exception;

	List<Perfume> getPerfumesByBrand(Integer brandId) throws Exception;
}
