package jaraws.hibernate;

import org.hibernate.Query;

public class ReadMe {

	/**
	 * 
	 * Parameter Binding and SQL Injection:
	 * ------------------------------------------------------
	 * 
	 * Parameter binding is the way using which we bind a variable value with its placeholder
	 * inside the query, to be executed by the hibernate.
	 * 
	 * Parameter binding provides a way to avoid SQL injection attack on to the systems.
	 * 
	 * Example of an SQL injection:
	 * String userId = " 5 or 1=1"; // String "or 1=1" is an example of sql injection here, where 1==1 has been injected that where clause will always return true
	 * Query q = session.createQuery("from UserDetails where userId > "+ userId);
	 * 
	 * There are two ways using which the parameter binding could be used in hibernate
	 * 1. Using ? place holders:
	 * 		Query query = session.createQuery("from UserDetails where id > ? and userName = ?");
	 * 		query.setInteger(0, 2); // 1st parameter, the first argument represent the index value of ? mark character
	 * 		query.setString(1, "suzan"); // 2nd parameter
	 * 
	 * 2. Using named place holders:
	 *   	Query query = session.createQuery("from UserDetails where id > :userId and userName = :userName");
	 * 		query.setInteger("userId", 2); // 1st parameter, the first argument represent the index value of ? mark character
	 * 		query.setString("userName", "suzan"); // 2nd parameter
	 * 
	 */
}
