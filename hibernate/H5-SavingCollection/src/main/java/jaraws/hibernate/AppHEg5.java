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
public class AppHEg5 
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
			st.setFirstName("Troy");
			st.setLastName("Jacob");
			st.setAge(21);
			
			// Creating type of Value type
			Address ad1 = new Address();
			ad1.setStreet1("street2");
			ad1.setCity("city2");
			ad1.setHouseNo(2332);
			ad1.setState("Kia");
			ad1.setPinCode(1111411);

			// Setting up the Value type in Entity type
			//st.setTempAddress(ad);
			
			Address ad2 = new Address();
			ad2.setStreet1("p_street1");
			ad2.setCity("p_city1");
			ad2.setHouseNo(1233);
			ad2.setState("p_Marlin");
			ad2.setPinCode(2111111);

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
		txn = session.beginTransaction();
		// Since, we are using ORM we will for now be dealing with classes and their instances 
		// only i.e we would no where for now specify the db objects and queries to be executed 
		// over them. However, there are ways provided by Hibernate where we can directly use
		//  required db queries.
		st = (Student) session.get(Student.class, 1);
		System.out.println("Read executed....");
		System.out.println("Student Detail retrieved: "+ st);
		
		txn.commit();
		session.close();
			
		//System.exit(0);
	}
}
