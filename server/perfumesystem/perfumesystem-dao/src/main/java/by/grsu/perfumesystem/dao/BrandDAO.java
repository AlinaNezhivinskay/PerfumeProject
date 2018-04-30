package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IBrandDAO;
import by.grsu.perfumesystem.model.Brand;

@Repository
public class BrandDAO extends AbstractDAO<Brand> implements IBrandDAO {

}
