package by.grsu.perfumesystem.api.sevice;

import java.util.List;

import by.grsu.perfumesystem.model.Brand;

public interface IBrandService {

	void addBrand(Brand brand) throws Exception;

	void removeBrand(Brand brand) throws Exception;

	void updateBrand(Brand brand) throws Exception;

	List<Brand> getAllBrand() throws Exception;

	Brand getBrandById(Integer id) throws Exception;

	List<Brand> getBrandsByCountry(Integer countryId) throws Exception;
}
