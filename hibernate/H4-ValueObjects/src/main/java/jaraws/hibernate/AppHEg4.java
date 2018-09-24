package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.Address;
import jaraws.hibernate.model.Student;

/**
 * Hello world!
 *
 */
public class AppHEg4 
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
			st.setFirstName("Robin");
			st.setLastName("Jacob");
			st.setAge(21);
			
			// Creating type of Value type
			Address ad = new Address();
			ad.setStreet1("street1");
			ad.setCity("city1");
			ad.setHouseNo(233);
			ad.setState("Marlin");
			ad.setPinCode(111111);

			// Setting up the Value type in Entity type
			st.setTempAddress(ad);
			
			Address pad = new Address();
			pad.setStreet1("p_street1");
			pad.setCity("p_city1");
			pad.setHouseNo(1233);
			pad.setState("p_Marlin");
			pad.setPinCode(2111111);

			// Setting up the Value type in Entity type
			st.setPermAddress(pad);
			
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
		
		System.out.println("Reading executed....");
		
		st =null;
		
		// Create a new session object or open a new connection
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		// Since, we are using ORM we will for now be dealing with classes and their instances 
		// only i.e we would no where for now specify the db objects and queries to be executed 
		// over them. However, there are ways provided by Hibernate where we can directly use
		//  required db queries.
		st = (Student) session.get(Student.class, 1);
		
		System.out.println("Student Detail retrieved: "+ st);
		
		txn.commit();
		session.close();
		
	}
}
