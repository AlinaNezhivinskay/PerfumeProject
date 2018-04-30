package by.grsu.perfumesystem.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Note.class)
public abstract class Note_ {

	public static volatile SingularAttribute<Note, Byte[]> image;
	public static volatile SingularAttribute<Note, String> name;
	public static volatile SingularAttribute<Note, Integer> id;
	public static volatile SingularAttribute<Note, NoteGroup> group;

}

