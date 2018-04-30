package by.grsu.perfumesystem.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserInfo.class)
public abstract class UserInfo_ {

	public static volatile ListAttribute<UserInfo, Perfume> pefumes;
	public static volatile SingularAttribute<UserInfo, String> name;
	public static volatile SingularAttribute<UserInfo, Integer> id;
	public static volatile SingularAttribute<UserInfo, String> email;

}

