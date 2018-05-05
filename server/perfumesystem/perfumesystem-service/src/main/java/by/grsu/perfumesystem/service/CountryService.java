package by.grsu.perfumesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.grsu.perfumesystem.api.dao.ICountryDAO;
import by.grsu.perfumesystem.api.sevice.ICountryService;
import by.grsu.perfumesystem.model.Country;

@Service
@Transactional
public class CountryService implements ICountryService {

	@Autowired
	private ICountryDAO countryDAO;

	public void addCountry(Country country) throws Exception {
		countryDAO.create(country);

	}

	public void removeCountry(Country country) throws Exception {
		countryDAO.delete(country);

	}

	public void updateCountry(Country country) throws Exception {
		countryDAO.update(country);

	}

	public List<Country> getAllCountry() throws Exception {
		return countryDAO.getAll();
	}

	public Country getCountryById(Integer id) throws Exception {
		return countryDAO.getById(id);
	}

}
