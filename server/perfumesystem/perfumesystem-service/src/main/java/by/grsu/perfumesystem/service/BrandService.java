package by.grsu.perfumesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grsu.perfumesystem.api.dao.IBrandDAO;
import by.grsu.perfumesystem.api.sevice.IBrandService;
import by.grsu.perfumesystem.model.Brand;

@Service
@Transactional
public class BrandService implements IBrandService {

	@Autowired
	private IBrandDAO brandDAO;

	public void addBrand(Brand brand) throws Exception {
		brandDAO.create(brand);
	}

	public void removeBrand(Brand brand) throws Exception {
		brandDAO.delete(brand);
	}

	public void updateBrand(Brand brand) throws Exception {
		brandDAO.update(brand);
	}

	public List<Brand> getAllBrand() throws Exception {
		return brandDAO.getAll();
	}

	public Brand getBrandById(Integer id) throws Exception {
		Brand brand = brandDAO.getById(id);
		return brand;
	}

}
