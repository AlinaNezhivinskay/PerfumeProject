package by.grsu.perfumesystem.api.dao.genericdao;

import java.util.List;

public interface GenericDAO <T> {
	
	void create(T object) throws Exception;

	T getById(Integer key) throws Exception;

	void update(T object) throws Exception;

	void saveOrUpdate(T object) throws Exception;

	void delete(T object) throws Exception;

	List<T> getAll() throws Exception;
}
