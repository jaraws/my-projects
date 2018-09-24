package jaraws.hibernate;

public class ReadMe {

	/**
	 * HQL
	 * ------------------------------------------------------
	 * 
	 * In HQL we do not talk about tables but we talk about classes and objects here.
	 * 
	 * In HQL, instead of using the table name we make use of class name.
	 * and instead of using the column name we make use of member variable
	 * name.
	 * 
	 * And, instead of returning a result set hibernate returns the list.
	 * 
	 * Eg:
	 * In HQL we mention the class names and member variable names
	 * query = session.createQuery("from UserDetails where userId > 2");  
	 * list = query.list();
	 * 
	 * Pagination:
	 * With this feature we can make the hibernate to start fetching the location from a given index
	 * and then we can read a given set of records as well.
	 * 
	 * query = session.createQuery("from UserDetails"); 
	 * query.setFirstResult(2); // retrieves the 2nd record from all the records
	 * query.setMaxResults(2); // This will tell the hibernate to pull exactly 2 records of the table
	 * 
	 * The above example will read the forst record at index 2 and will overall fetch only 2 records
	 * from the table. This way we can use these 2 properties to implement pagination.
	 * 
	 * 
	 */
}
