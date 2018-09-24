package jaraws.hibernate;

public class ReadMe {

	/*
	 * ONE TO MANY BIDIRECTIONAL [mappedBy property]
	 * --------------------------------------
	 * 
	 * The difference "mappedBy" property brings to the example is that Hibernate
	 * DOES NOT create a separate table(JOIN TABLE) to maintain one to many relationship as it does
	 * in previous example. Here, Hibernate creates a mapping of UserDetail in Vehicle table
	 * only as USER_ID. And using the same it allows to access all Vehicles using UserDetails
	 * and UserDetails using Vehicles i.e. supports OneToMany bidirectional relationship.
	 * 
	 * NOTE: 
	 * -------------------------------------------------------------
	 * We just need to reference the name of the association attribute of the many side as the 
	 * value of the mappedBy attribute and Hibernate has all the information it needs.
	 * 
	 * This example covers "ONE TO MANY BIDIRECTIONAL" association i.e. it is possible to 
	 * fetch ALL VEHICLE(s) associated with a USER_DETAIL and USER_DETAIL associated 
	 * with a VEHICLE as well vice versa.
	 * 
	 * In this example we will see how an entity can be mapped with another entity
	 * i.e. an entity inside another entity. JPA supports different strategies for
	 * defining relationship between entities. Here, we will discuss @OneToMany
	 * and @ManyToOne mapping between two different entities.
	 * 
	 * By OneToMany mapping we mean that there could be multiple instance of an
	 * entity inside another entity. Here, we have taken UserDetail and Vehicle as
	 * model classes having one to many relationship between them i.e. One
	 * UserDetail can have only multiple Vehicle.
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