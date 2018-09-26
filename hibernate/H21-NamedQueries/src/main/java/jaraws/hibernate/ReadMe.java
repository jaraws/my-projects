package jaraws.hibernate;

import javax.persistence.NamedNativeQuery;

import jaraws.hibernate.model.UserDetails;

public class ReadMe {

	/**
	 * Named Queries:
	 * ----------------------------------------------------------------
	 * 
	 * Its usually considered as best practice that we keep all the application queries at one place
	 * rather than having queries scattered around the entire application.
	 * 
	 * Following this approach we can directly to go the place  where we have kept the application 
	 * queries and update them as and when required. It certainly makes it easy to maintain and
	 * organize the queries at one place.
	 * 
	 * The defined named queries can be accessed from anywhere inside the application.
	 * 
	 * The queries related to an entity can be kept right above the entity class itself. This will help us
	 * consolidating all queries related to an entity with the entity itself.
	 * 
	 * The name of the named query should be given as <entity-name>.<noun identifying the work done by query>
	 * For eg: 
	 * 	>> @NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = ?")
	 *  >> @NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = :userId")
	 * 
	 * NamedNativeQueries:
	 * -------------------------
	 * NamedNativeQueries could be used to write the queries native to the database. Here, we write the
	 * entire query by ourself and do not rely on hibernate to generate the query for us.
	 * 
	 * IMPORTANT:
	 * The only difference which comes between a NamedQuery and NamedNative query is that, in 
	 * NamedNativeQuery we have to explicitly tell the RESULT class to the hibernate to cast 
	 * the result into result class. The same is not necessary in HQL as we provide the result class
	 * name in the hql statement itself as 'from <result-class> where userId = ?'
	 * 
	 * Eg:
	 * @NamedNativeQuery(name="UserDetails.byName", 
					query="select * from USER_DETAILS where user_name =:userName",
						resultClass=UserDetails.class)
	 * 
	 */
}
