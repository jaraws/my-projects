package jaraws.hibernate;

public class ReadMe {

	/*
	 * Saving Collections
	 * ---------------------------------------
	 *	
	 * This example explains the concept of "Proxy Objects", "Lazy Initialization" and 
	 * "Eager Initialization" in Hibernate.
	 * 
	 * In Lazy initialization only 1st level instance variables of an object are initialized.
	 * In Eager initialization all the instance variables of an object are initialized at once.
	 * 
	 * IMPORTANT
	 * ------------------------------------------
	 * The DEFAULT strategy which Hibernate follows is LAZY initialization. Hibernate achieves 
	 * it by means of Proxy object of the entity class object. When session.get(...) is invoked
	 * Hibernate returns a proxy object of entity class object having probably all its 1st level 
	 * instance variables initialized. And when we invoke the getter of 2nd level instance variables
	 * on the proxy object, then Hibernate fetches the corresponding values of 2nd level instance
	 * variables from the database.
	 */
}

