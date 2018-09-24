package jaraws.hibernate;

public class ReadMe {
	
	/*
	 * 1. Project explains the Value object types and Embedded  Objects.
	 * 
	 * 2. Types of Objects in Hibernate:
	 * -----------------------------------------
	 * 	2.1 Entity Objects: Object which need to be saved in a separate table in database. They are independent in themselves. 
	 * 		Eg: Student
	 *  2.2 Value Object: Object, which do not have their independent existence. They independently doesn't carry any meaning.
	 *  	Eg: Address (Address object has no meaning in itself, it has to be associated with some entity like Student, User etc.)
	 *  
	 * 3. We uses different approach when we deal with Entity objects and when we deal with Value objects.
	 *  
	 * 4. In case of Entity objects, Hibernate creates a separate table for them in database. However, for Value objects
	 *     Hibernate embeds there values within the parent Entity class table in database.
	 *     
	 * 5. An Entity Object class is represented with @Entity annotation.
	 * 
	 * 6. A Value Object class is represented with @Embeddable annotation. And when they are used within an Entity class they
	 *     are annotated with @Embedded annotation as shown in Student Entity class of this project.
	 *  	
	 * 7. Attribute Override: This feature is used when we have two Value objects of same type within an Entity class. It is
	 * 	  used to avoid the column name conflicts between the similar value objects.
	 * 	  For eg:
	 * 			Student has two value Address objects. One for permanent and another for temporary address. Now, in this case
	 * 			since we have two Address objects we have to have different column names for them.
	 * 			This is achieved by overriding the valu object attribute names in Entity class as shown in Student class in this
	 * 			example.  
	 * 
	 * @Embeddable Annotation:
	 * -------------------------------------------
	 *  >> An embedded object specified using jpa embeddable annotation does not represent a table in database.
	 *  >> It is not an Entity. It is simply owned by some Entity and it forms the field names of owning entity.
	 *  >> As Address is not an Entity, the relationship between Student and Address is not termed a a JPA relationship. It is simply an embedded object.
	 *  >> The purpose of embedded objects is re-usability. We can re-use address embedded object for some other class 
	 *     which has also the same fields in database representation.
	 */
}

