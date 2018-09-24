package jaraws.hibernate;

public class ReadMe {

	/*
	 * TransientObjectException
	 * --------------------------------------
	 * 
	 * Exception: Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - 
	 * 			  save the transient instance before flushing: jaraws.hibernate.model.Vehicle
	 * 
	 * 
	 * The exception means the object we are saving using session.save(UserDetails.class) is referring to another 
	 * transient object or Entity i.e. Vehicle which has not been saved yet. Hibernate expect the developer to save the 
	 * entity objects before invoking session.save on main entity(UserDetails here in this example). Since, Vehicle is 
	 * also an entity Hibernate expects its behavior should be provided that if it has to be saved or not.
	 * 
	 * Now there are 2 ways to handle this exception:
	 * 
	 * 1. Save the referred entity as session.save(..). as [Note: cascade=CascadeType.ALL will not be required in this case but it becomes a problem when
	 *    parent entity is referring lot of other child entities then invoking save over all the child entities gets cumbersome]
	 * 			session.save(vc1); 
	 * 			session.save(vc2);
	 * 			session.save(vc3);
	 * 			session.save(ud);
	 * 
	 * 2. Use CascadeType.PERSIST on the parent Entity collection of all child entities to save all its referred entities. Having CascadeType.PERSIST on a collection of
	 *    entities Hibernate save all the unsaved elements of the collection when a session.persist is invoked over a parent entity.
	 *    So, basically we are telling Hibernate to save the child entity collection while persisting the parent entity.
	 *    
	 *    And, if we want to cascade for all the operations like remove, detach, merge,refresh on save then we can choose CascadeType.ALL to cascade for all
	 *    session operations on parent entity.
	 */

}