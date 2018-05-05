package by.grsu.perfumesystem.api.sevice;

import java.util.List;

import by.grsu.perfumesystem.model.Country;

public interface ICountryService {
	
	void addCountry(Country country) throws Exception;

	void removeCountry(Country country) throws Exception;

	void updateCountry(Country country) throws Exception;

	List<Country> getAllCountry() throws Exception;

	Country getCountryById(Integer id) throws Exception;
	
}
