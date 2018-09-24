package jaraws.hibernate;

public class ReadMe {

	/*
	 * MANY TO MANY RELATIONSHIP
	 * --------------------------------------
	 * 
	 * Here, we are considering many-to-many bidirectional association that we can navigate in both the directions
	 * to access the entities. And for that we need to model or give the association definition on both the entities
	 * involved in association.
	 * 
	 * Using the same models we can assume Vehicle entity here as a rented vehicle i.e. a user can rent multiple 
	 * vehicles and a vehicle can be rented by multiple users. Hence, we can not have mapping of
	 * one entity into another table i.e none of the UserDetail and the Vehicle can have a mapping to 
	 * other entity. Hence, this mapping between the entities has to have in a separate table.
	 * 
	 * Here, we have to model the association on both entities if we want to navigate in both the directions i.e.
	 * need to model it as many-to-many association on the UserDetail and Vehicle entity.
	 * 
	 * NOTE: ASSOCIATION IS PREFERRED TO BE DEFINED AT OWNING SIDE ENTITY AND OTHER ENTITY JUST REFERENCES IT.
	 * 
	 * Let UserDetail be the owning side and let Vehicle refer the association defined by UserDetail.
	 * 
	 * A many to many relationship is maintained by a 3rd separate MAPPING table.
	 * 
	 * Here, Vehicle is not a value object. It has its identity and is an entity in
	 * itself. And, in Hibernate a separate table is created for the entity class.
	 */

}