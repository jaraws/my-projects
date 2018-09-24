package jaraws.hibernate;

public class ReadMe {

	/*
	 * ONE TO MANY UNIDIRECTIONAL
	 * ---------------------------------------------
	 * This example covers "ONE TO MANY UNIDIRECTIONAL" association i.e. it is possible to 
	 * fetch ALL VEHICLE(s) associated with a USER_DETAIL but it is not possible to fetch
	 * the USER_DETAIL associated with a VEHICLE.
	 * 
	 * Different Entity to Entity Mapping supported by JPA 
	 * ---------------------------------------
	 * 
	 * >> @OneToMany: Unidirectional (Covered by this example)
	 * >> @ManyToOne: Unidirectional (This is similar to this example with a bit of tweaks in code and with a vice versa functionality)
	 * >> @OneToMany + @ManyToOne: Bidirectional
	 * 
	 * So far we have seen the examples of saving value objects inside an entity.
	 * Where we have seen how can we save value object as the columns of entity
	 * table using
	 * 
	 * @Embedded annotation and as a separate table using @ElementCollection
	 * annotation along with LAZY and EAGER initialization fetch type strategies.
	 * 
	 * In this example we will see how an entity can be mapped with another entity
	 * i.e. an entity inside another entity. JPA supports different strategies for
	 * defining relationship between entities. Here, we will discuss @OneToMany
	 * and @ManyToOne mapping between two different entities.
	 * 
	 * By OneToMany mapping we mean that there could be multiple instance of an
	 * entity inside another entity. Here, we have taken UserDetail and Vehicle as
	 * model classes having one to many relationship between them i.e. One
	 * UserDetail can have only multiple Vehicle(One user can have multiple Vehicles).
	 * 
	 * Here, Vehicle is not a value object. It has its identity and is an entity in
	 * itself. And, in Hibernate a separate table is created for the entity class.
	 */

	/*
	 * @OneToMany(cascade= {CascadeType.ALL})
	 * @ManyToOne(cascade= {CascadeType.ALL})
	 * 
	 * To avoid the below exception:
	 * 
	 * Exception: Caused by: org.hibernate.TransientObjectException: object
	 * references an unsaved transient instance - save the transient instance before
	 * flushing: jaraws.hibernate.model.Vehicle .......................
	 * .............
	 * 
	 * We should include cascade="all" (if using xml) or cascade=CascadeType.ALL (if
	 * using annotations) on our collection/entity mapping. This happens because we
	 * have a collection/entity in our parent entity and that collection/entity has
	 * one or more items which are not present in the database. By specifying the
	 * above options we tell Hibernate to save them to the database when saving
	 * their parent entity.
	 * 
	 */

}