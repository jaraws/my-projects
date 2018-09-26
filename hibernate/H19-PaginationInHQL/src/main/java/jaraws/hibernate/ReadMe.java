package jaraws.hibernate;

public class ReadMe {

	/**
	 * 
	 * Pagination:
	 * ------------------------------------------------------
	 * 
	 * With this feature we can make the hibernate to start fetching the location from a given index
	 * and then we can read a given set of records as well.
	 * 
	 * query = session.createQuery("from UserDetails"); 
	 * query.setFirstResult(2); 
	 * // retrieves the records starting from index 2, considering that the index values starts from 0.
	 * query.setMaxResults(2); 
	 * // This will tell the hibernate to pull exactly 2 records of the table no matter how many records we have in our table
	 * 
	 * 
	 * The above example will read the first record at index 3 and will overall fetch only 2 records
	 * from the table. This way we can use these 2 properties to implement pagination using query api
	 * of hibernate.
	 * 
	 * 
	 * Pagination is the solution to the problem of reading huge number of records from the database at once.
	 * It is advisable to read the data in chunks rather than reading all the data by one query to avoid the
	 * performance issues.
	 * 
	 * 
	 * 
	 */
}
