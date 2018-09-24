package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.UserDetails;
import jaraws.hibernate.model.Vehicle;

/**
 * Hello world!
 *
 */
public class AppHEg9 
{
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		System.out.println("Inserting object ...");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		@SuppressWarnings("resource")
		Session session = null;
		Transaction txn = null;
		UserDetails ud =null;
		Vehicle vc = null;
		
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();

			// Creating an instance of Entity type
			ud = new UserDetails();
			ud.setFirstName("Rina");
			ud.setLastName("Jacob");
			ud.setAge(21);
			
			// Creating an instance of Entity type
			vc = new Vehicle();
			vc.setVehicleType("Bicycle");
			ud.getVehicle().add(vc);
			
			// Creating an instance of Entity type
			vc = new Vehicle();
			vc.setVehicleType("Car");
			ud.getVehicle().add(vc);
			
			// Creating an instance of Entity type
			vc = new Vehicle();
			vc.setVehicleType("Bus");
			ud.getVehicle().add(vc);
			
						
			session.save(ud);
			
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		System.out.println("Insert executed....");
		
		
		ud =null;
		
		// Create a new session object or open a new connection
		session = sessionFactory.openSession();
		// Since, we are using ORM we will for now be dealing with classes and their instances 
		// only i.e we would no where for now specify the db objects and queries to be executed 
		// over them. However, there are ways provided by Hibernate where we can directly use
		//  required db queries.
		ud = (UserDetails) session.get(UserDetails.class, 1);
		
		vc = (Vehicle) session.get(Vehicle.class,2);
		/*
		 *  NOTE: 
		 *  BY NOW HIBERNATE WOULD HAVE INITIALIZED 1ST LEVEL INSTANCE VARIABLES ONLY AND THIS COULD
		 *  BE VERIFIED BY CLOSING THE SESSION BEFORE ACCESSING THE SECOND LEVEL INSTANCE VARIABLES OF
		 *  ENTITY OBJECT
		 */

		System.out.println("Read executed....");
		System.out.println(ud);
		
		/*
		 * Since, it is a OneToMany relationship from User_Detail to Vehicle we would not be able
		 * to fetch the USER_DETAILS from a vehicle
		 */
		System.out.println(vc);
		
		/*
		 * Here, we have closed the session before Hibernate tries to lazy initialize the listOfAddresses, which
		 * would result into LazyInitializationException. However, the same exception could be avoided by closing
		 * the session after accessing the second level instance variables from the entity object.
		 */
		session.close();  
		//session.close();
		sessionFactory.close();
			
		//System.exit(0);
	}
}
