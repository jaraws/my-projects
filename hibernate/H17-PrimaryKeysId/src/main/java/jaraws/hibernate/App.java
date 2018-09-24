package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.UserDetailsTable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	


		Transaction tx = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			/*
			 *  It builds the session factory from the Hibernate configuration
			 *  defined in Hibernate-configuration-file present in class path
			 *  i.e. hibernate.cfg.xml
			 */
			sessionFactory  = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			UserDetailsTable userDetails1 =new UserDetailsTable();
			userDetails1.setUserName("First User");
			
			UserDetailsTable userDetails2 =new UserDetailsTable();
			userDetails2.setUserName("Second User");
			
			UserDetailsTable userDetails3 =new UserDetailsTable();
			userDetails3.setUserName("Third User");
			
			tx = session.beginTransaction();
			session.save(userDetails1); // Here, the state of the object changes from Transient to persistence
			session.save(userDetails2);
			session.save(userDetails3);
			tx.commit();
		} catch (Exception ex) {
			if(tx!=null)tx.rollback();
			ex.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			if(session!=null) {
				sessionFactory.close();
			}
		}
		System.out.println("finished execution....");
	
    }
}
