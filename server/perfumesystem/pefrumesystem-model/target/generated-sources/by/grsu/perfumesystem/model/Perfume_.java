package by.grsu.perfumesystem.model;

import by.grsu.perfumesystem.model.util.PerfumeType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Perfume.class)
public abstract class Perfume_ {

	public static volatile SingularAttribute<Perfume, Byte[]> image;
	public static volatile SingularAttribute<Perfume, PerfumeCondition> condition;
	public static volatile ListAttribute<Perfume, NotePyramide> notes;
	public static volatile SingularAttribute<Perfume, String> name;
	public static volatile SingularAttribute<Perfume, Integer> id;
	public static volatile SingularAttribute<Perfume, PerfumeType> type;
	public static volatile SingularAttribute<Perfume, Brand> brand;
	public static volatile SingularAttribute<Perfume, Integer> releaseYear;

}

