package jaraws.hibernate;

public class ReadMe {

	/*
	 * ONE TO MANY / MANY TO ONE BIDIRECTIONAL 
	 * --------------------------------------------
	 * This example covers "ONE TO MANY / MNAY TO ONE BIDIRECTIONAL" association i.e. it is possible to 
	 * fetch ALL VEHICLE(s) associated with a USER_DETAIL and all USER_DETAILS associated 
	 * with a VEHICLE as well.
	 * 
	 * The assumption which has been made in this example is that a user can have multiple vehicles associated 
	 * with it but a vehicle will have exactly one user associated with it.
	 * 
	 * IMPORTANT NOTE ABOUT: ONE-TO-MANY/MANY-TO-ONE BIDIRECTIONAL MAPPING
	 * ------------------------------------------------------------------------------------------------
	 * > Bidirectional one-to-many/many-to-one associations are just one way to model relationships between entities.
	 * 
	 * > With Bi-Directional, it is meant that one entity can be accessed via another entity.
	 * 
	 * > In a Bi-Directional relationship we need to model the association on both the entities if we want to navigate in both 
	 *   the directions.
	 *   
	 * > According to the domain model of this example, the UserDetails entity will have one-to-many association to Vehicle
	 *   entity and Vehicle entity will have many-to-one association to UserDetails entity.
	 *   
	 * > ENTITY ON MANY SIDE OF "ONE-TO-MANY" OR "MANY-TO-ONE" ASSOCIATION IS ALWAYS CONSIDERED AS OWNING SIDE OF THE ASSOCIATION.
	 * 
	 * > Bidirectional associations are easy to use in queries, but they also require an additional step when you persist or remove 
	 *   a entity. We need to update the association on both sides when we add or remove an entity. We can see an example 
	 *   of it in the examples code snippet, in which we first create a new UserDetails entity and then created a Vehicle entity, 
	 *   later Vehicle is added to UserDetails vehicle list and Vehicle is also updated with the same UserDetails.
	 *   
	 * > Updating the associations on both entities is an error-prone task. Therefore, it’s a good practice to provide a helper method 
	 *   that adds another entity to the many side of the association. 
	 *   
	 *    @Entity
	 *    public class UserDetails{
	 *    
	 *    	public void addVehicle(Vehicle vehicle){
	 *    		this.vehicle.add(vehicle);
	 *    		vehicle.setUser(this); // adding UserDetails to the many side of the association
	 *    	}
	 *    }
	 * ------------------------------------------------------------------------------------------------ 
	 * 
	 * 
	 * By OneToMany mapping we mean that there could be multiple instance of an entity inside another entity. Here, we have 
	 * taken UserDetail and Vehicle as model classes having one to many relationship between them i.e. One UserDetail can 
	 * have multiple Vehicle.
	 * 
	 * Here, Vehicle is not a value object. It has its identity and is an entity in itself. And, in Hibernate a separate table 
	 * is created for the entity class.
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