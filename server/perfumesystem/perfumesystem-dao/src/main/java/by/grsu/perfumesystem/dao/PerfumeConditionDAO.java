package by.grsu.perfumesystem.dao;

import org.springframework.stereotype.Repository;

import by.grsu.perfumesystem.api.dao.IPerfumeConditionDAO;
import by.grsu.perfumesystem.model.PerfumeCondition;

@Repository
public class PerfumeConditionDAO extends AbstractDAO<PerfumeCondition> implements IPerfumeConditionDAO {

}
