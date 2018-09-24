package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.Student;

/**
 * Hello world!
 *
 */
public class AppHEg2 {
	
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction txn =null;
		
		Student student = new Student();
		student.setId("1");
		student.setFirstName("Ronit");
		student.setLastName("Jacob");
		student.setAge(21);

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.save(student);
			txn.commit();
		} catch (Exception e) {
			if(txn!=null)
				txn.rollback();
			// Below statement is from POC perspective only
			e.printStackTrace();
		}finally {
			// Always close session and session factory in finally block
			session.close();
			sessionFactory.close();
		}
		
		System.out.println("Exiting Programme......");
	}
}
