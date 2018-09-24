package jaraws.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.ClassDetail;

/**
 * Hello world!
 *
 */
public class AppHEg3 {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		System.out.println("Inserting object ...");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		@SuppressWarnings("resource")
		Session session = null;
		Transaction txn = null;
		ClassDetail cd =null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();

			cd = new ClassDetail();

			cd.setId("4");
			cd.setClassName("four");
			cd.setClassSection("d");
			cd.setStrength(50);
			cd.setEstablisedDate(new Date());
			session.save(cd);
			
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
		
		cd =null;
		
		// Create a new session object or open a new connection
		session = sessionFactory.openSession();
		txn = session.beginTransaction();
		// Since, we are using ORM we will for now be dealing with classes and their instances 
		// only i.e we would no where for now specify the db objects and queries to be executed 
		// over them. However, there are ways provided by Hibernate where we can directly use
		//  required db queries.
		cd = (ClassDetail) session.get(ClassDetail.class, "3");
		
		System.out.println("Class Detail retrieved: "+ cd);
		
		txn.commit();
		session.close();
		
		
	}
}
