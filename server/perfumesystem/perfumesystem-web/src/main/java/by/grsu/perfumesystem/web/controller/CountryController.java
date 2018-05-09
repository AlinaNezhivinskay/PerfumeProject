package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.grsu.perfumesystem.api.sevice.ICountryService;
import by.grsu.perfumesystem.model.Country;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private ICountryService countryService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Country> getCountries() {
		List<Country> answer = null;
		try {
			answer = countryService.getAllCountry();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Country getCountry(@RequestParam Integer id) {
		Country answer = null;
		try {
			answer = countryService.getCountryById(id);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		return answer;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public void addCountry(@RequestBody Country country) {
		try {
			countryService.addCountry(country);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public void removeCountry(@RequestBody Country country) {
		try {
			countryService.removeCountry(country);
		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}
}
