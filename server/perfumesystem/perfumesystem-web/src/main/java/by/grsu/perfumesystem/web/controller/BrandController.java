package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
