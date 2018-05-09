package by.grsu.perfumesystem.api.dao;

import java.util.List;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;
import by.grsu.perfumesystem.model.Brand;

public interface IBrandDAO extends GenericDAO<Brand> {
	
	List<Brand> getBrandsByCountry(Integer countryId) throws Exception;
}
