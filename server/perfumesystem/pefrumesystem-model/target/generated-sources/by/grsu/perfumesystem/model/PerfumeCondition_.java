package by.grsu.perfumesystem.model;

import by.grsu.perfumesystem.model.util.Daytime;
import by.grsu.perfumesystem.model.util.WeatherType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PerfumeCondition.class)
public abstract class PerfumeCondition_ {

	public static volatile SingularAttribute<PerfumeCondition, WeatherType> weather;
	public static volatile SingularAttribute<PerfumeCondition, Double> temperature;
	public static volatile SingularAttribute<PerfumeCondition, Integer> id;
	public static volatile SingularAttribute<PerfumeCondition, Daytime> daytime;

}

