package jaraws.hibernate;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

public class ReadMe {

	/*
	 * Hibernate Inheritance: SINGLE TABLE STRATEGY 
	 * ---------------------------------------------
	 * 
	 * This is achieved using annotation: 
	 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
	 * 
	 * Hibernate follows the single table strategy while implementing Inheritance in database i.e.
	 * Hibernate create one common table for all the classes or entities which belong to same hierarchy
	 * tree. And differentiate between them by means of "Discriminatory Column" which is created by
	 * Hibernate itself.It maps all the child entities with the base class table itself.
	 * 
	 * This is also the default strategy used by Hibernate if no other inheritance strategy is explicitly 
	 * defined.
	 * 
	 * Sub classes not only inherits the properties from parent class but they also inherits the annotation along with
	 * them if property is annotated with an annotation. Like @Id, @Generated etc. It means that even 
	 * the child class will have an identity and a key generation strategy. When you will run this example
	 * you will find that both the sub class entities will be having their own values generated for
	 * parent class member variable id and vehicle_type.
	 * 
	 * Apart from that Hibernate creates an additional column to the single table for every new
	 * column it finds in class hierarchy. 
	 * 
	 * This is the DEFAULT STRATEGY that is followed by Hibernate when we do not provide any inheritance 
	 * configuration.
	 * 
	 * THIS IS THE LEAST NORMALISED STRATEGY.
	 */
}