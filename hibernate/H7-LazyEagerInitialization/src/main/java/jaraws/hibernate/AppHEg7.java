package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.Address;
import jaraws.hibernate.model.Student;

/**
 * Lazy Initilization: It means hibernate will only initialize the first level member(instance)
 * variables of an object on get(..). However, the second level instance variable will be
 * initialized only when a these member variables are explicitly accessed.
 * 
 * In lazy initialization, hibernate instead of returning the actual object it basically returns the
 * proxy class object not the actual target class.
 *
 */
public class AppHEg7 
{
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		System.out.println("Inserting object ...");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		@SuppressWarnings("resource")
		Session session = null;
		Transaction txn = null;
		Student st =null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();

			// Creating an instance of Entity type
			st = new Student();
			//st.setId("1");
			st.setFirstName("Kiap");
			st.setLastName("Jacob");
			st.setAge(21);
			
			// Creating type of Value type
			Address ad1 = new Address();
			ad1.setStreet1("stareet12");
			ad1.setCity("cit1sy2");
			ad1.setHouseNo(2332);
			ad1.setState("Kissa");
			ad1.setPinCode(1411);

			// Setting up the Value type in Entity type
			//st.setTempAddress(ad);
			
			Address ad2 = new Address();
			ad2.setStreet1("p_stareesst1");
			ad2.setCity("p_cissaty1");
			ad2.setHouseNo(122333);
			ad2.setState("p_Msaarlin");
			ad2.setPinCode(21112111);

			// Setting up the Value type in Entity type
			st.getListOfAddresses().add(ad1);
			st.getListOfAddresses().add(ad2);
			
			session.save(st);
			
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
		
		
		st =null;
		
		// Create a new session object or open a new connection
		session = sessionFactory.openSession();
		// Since, we are using ORM we will for now be dealing with classes and their instances 
		// only i.e we would no where specify the data base objects and queries to be executed 
		// over them. However, there are ways provided by Hibernate where we can directly use
		//  required db queries.
		st = (Student) session.get(Student.class, 1);
		
		/*
		 *  NOTE: 
		 *  BY NOW HIBERNATE WOULD HAVE INITIALIZED 1ST LEVEL INSTANCE VARIABLES ONLY AND THIS COULD
		 *  BE VERIFIED BY CLOSING THE SESSION BEFORE ACCESSING THE SECOND LEVEL INSTANCE VARIABLES OF
		 *  ENTITY OBJECT.
		 */

		System.out.println("Read executed....");
		/*
		 * Here, we have closed the session before Hibernate tries to lazy initialize the listOfAddresses, which
		 * would result into LazyInitializationException. However, the same exception could be avoided by closing
		 * the session after accessing the second level instance variables from the entity object.
		 */
		session.close();  
		System.out.println("Student Detail retrieved: "+ st.getListOfAddresses());
		//session.close();
		
			
		//System.exit(0);
	}
}
