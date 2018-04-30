package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IAddressDAO;
import by.grsu.perfumesystem.model.Address;

@Repository
public class AddressDAO extends AbstractDAO<Address> implements IAddressDAO {

}
