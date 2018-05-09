package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grsu.perfumesystem.api.sevice.IBrandService;
import by.grsu.perfumesystem.model.Brand;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Brand> getBrands() {
		List<Brand> answer = null;
		try {
			answer = brandService.getAllBrand();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Brand getBrand(@RequestParam Integer id) {
		Brand answer = null;
		try {
			answer = brandService.getBrandById(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/by_country", method = RequestMethod.GET)
	public List<Brand> getBrandsByCountry(@RequestParam Integer id) {
		List<Brand> answer = null;
		try {
			answer = brandService.getBrandsByCountry(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addBrand(@RequestBody Brand brand) {
		try {
			brandService.addBrand(brand);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void removeBrand(@RequestBody Brand brand) {
		try {
			brandService.removeBrand(brand);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}
}
