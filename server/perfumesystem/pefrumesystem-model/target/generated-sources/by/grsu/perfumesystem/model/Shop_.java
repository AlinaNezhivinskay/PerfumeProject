package by.grsu.perfumesystem.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Shop.class)
public abstract class Shop_ {

	public static volatile SingularAttribute<Shop, Address> address;
	public static volatile ListAttribute<Shop, Brand> brands;
	public static volatile SingularAttribute<Shop, String> contact;
	public static volatile SingularAttribute<Shop, String> name;
	public static volatile SingularAttribute<Shop, Integer> id;

}

