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
public class AppHEg1 {

	/*
	 *  Ideally there should be exactly on instance of SessionFactory
	 *  in an application using which we can obtain n number of session objects
	 *  to perform the database operations. One session represents one connection
	 *  to the database.
	 */
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		Transaction tx = null;
		Session session = null;
		try {
			/*
			 *  It builds the session factory from the Hibernate configuration
			 *  defined in Hibernate-configuration-file present in class path
			 *  i.e. hibernate.cfg.xml
			 */
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Student student =new Student("Robin", "Hood", 21);
			tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}finally {
			session.close();
			sessionFactory.close();
		}
		System.out.println("finished execution....");
	}
}
