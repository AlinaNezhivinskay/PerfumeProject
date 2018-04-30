package by.grsu.perfumesystem.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, Country> country;
	public static volatile SingularAttribute<Address, String> town;
	public static volatile SingularAttribute<Address, String> street;
	public static volatile SingularAttribute<Address, String> houseNumber;
	public static volatile SingularAttribute<Address, Integer> id;

}

