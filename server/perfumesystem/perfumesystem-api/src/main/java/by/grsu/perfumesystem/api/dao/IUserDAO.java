package by.grsu.perfumesystem.api.dao;

import by.grsu.perfumesystem.api.dao.genericdao.GenericDAO;
import by.grsu.perfumesystem.model.User;

public interface IUserDAO extends GenericDAO<User> {
	
	User getUserByLogin(String login) throws Exception;

}
