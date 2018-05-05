package by.grsu.perfumesystem.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
