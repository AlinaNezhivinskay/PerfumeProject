package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IUserInfoDAO;
import by.grsu.perfumesystem.model.UserInfo;

@Repository
public class UserInfoDAO extends AbstractDAO<UserInfo> implements IUserInfoDAO {

}
