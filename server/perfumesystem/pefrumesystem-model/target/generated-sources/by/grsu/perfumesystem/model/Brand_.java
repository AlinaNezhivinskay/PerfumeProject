package by.grsu.perfumesystem.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Brand.class)
public abstract class Brand_ {

	public static volatile SingularAttribute<Brand, Country> country;
	public static volatile SingularAttribute<Brand, String> site;
	public static volatile SingularAttribute<Brand, String> name;
	public static volatile ListAttribute<Brand, Shop> shops;
	public static volatile SingularAttribute<Brand, Integer> id;

}

