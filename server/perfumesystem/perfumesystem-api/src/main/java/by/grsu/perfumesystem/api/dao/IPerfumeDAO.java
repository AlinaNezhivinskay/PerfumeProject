package by.grsu.perfumesystem.api.dao;

import java.util.List;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;
import by.grsu.perfumesystem.model.Perfume;

public interface IPerfumeDAO extends GenericDAO<Perfume> {

	List<Perfume> getParfumesByBrand(Integer brandId) throws Exception;
}
