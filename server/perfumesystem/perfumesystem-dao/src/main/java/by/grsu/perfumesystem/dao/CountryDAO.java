package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.ICountryDAO;
import by.grsu.perfumesystem.model.Country;

@Repository
public class CountryDAO extends AbstractDAO<Country> implements ICountryDAO {

}
