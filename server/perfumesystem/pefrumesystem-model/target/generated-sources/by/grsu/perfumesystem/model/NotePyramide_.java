package by.grsu.perfumesystem.model;

import by.grsu.perfumesystem.model.util.PerfumePyramideType;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(NotePyramide.class)
public abstract class NotePyramide_ {

	public static volatile SingularAttribute<NotePyramide, Note> note;
	public static volatile SingularAttribute<NotePyramide, Integer> id;
	public static volatile SingularAttribute<NotePyramide, PerfumePyramideType> type;
	public static volatile SingularAttribute<NotePyramide, Perfume> perfume;

}

