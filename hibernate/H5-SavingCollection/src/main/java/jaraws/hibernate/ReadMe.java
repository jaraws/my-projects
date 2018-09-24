package jaraws.hibernate;

public class ReadMe {
	
	/*
	 * Saving Collections
	 * ---------------------------------------
	 * 
	 * In this example we will see how can we save collection type objects in database
	 * via Hibernate.
	 * 
	 * The example we discussed in HibernateEg4 has only 2 addresses in Student entity.
	 * There could be case where there would be more than 2 or more addresses corresponding 
	 * to an entity.
	 *   
	 * Here, we will create a separate table Address holding all the addresses corresponding to
	 * a Student Entity in it.
	 * 
	 * @ElementCollection
	 * ---------------------------------------------
	 * >> JPA ElementCollection annotation specifies that the field marked with @ElementCollection 
	 * 	  refers to the collection of embeddable or basic objects.
	 * >> @CollectionTable specifies the name of table in database in which collection information i.e. Address
	 *    is stored for Student entity with  name = "student_addresses" and the column which is used to 
	 *    refer the Student entity with joinColumns = @JoinColumn(name = "id")
	 */
	
}

