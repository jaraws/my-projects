package jaraws.hibernate;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jaraws.hibernate.model.UserDetails;;

/**
 * Hello world!
 *
 */
public class SelectAndPagination{
	
	private static final Logger logger   = LoggerFactory.getLogger(SelectAndPagination.class);

	private static SessionFactory sessionFactory;
	
	static {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction txn =null;
		
		UserDetails ud1 = new UserDetails();
		ud1.setUserName("mark");
		
		UserDetails ud2 = new UserDetails();
		ud2.setUserName("thomas");
		
		UserDetails ud3 = new UserDetails();
		ud3.setUserName("suzan");
		
		UserDetails ud4 = new UserDetails();
		ud4.setUserName("fisher");

		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			
			session.save(ud1);
			session.save(ud2);
			session.save(ud3);
			session.save(ud4);
			
			txn.commit();
		} catch (Exception e) {
			if(txn!=null)
				txn.rollback();
			// Below statement is from POC perspective only
			e.printStackTrace();
		}finally {
			// Always close session and session factory in finally block
			if(null!=session)
				session.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		Session session = null;
		Transaction txn =null;
		Query query = null;
		List<UserDetails> list = null;
		
		// Fetching the data using Query object
		try {
			System.out.println("**********************************************************************");
			
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			query = session.createQuery("from UserDetails"); 
			query.setFirstResult(2); // retrieves the 2nd record from all the records
			query.setMaxResults(2); // This will tell the hibernate to pull exactly 2 records of the table
			list = query.list();
			
			list.stream().forEach(ud->{
				logger.info("User ------> {}",ud);
			});
			
			System.out.println("**********************************************************************");
			
			
			
			txn.commit();
		} catch (Exception e) {
			if(txn!=null)
				txn.rollback();
			// Below statement is from POC perspective only
			e.printStackTrace();
		}finally {
			// Always close session and session factory in finally block
			if(null!=session)
				session.close();
			sessionFactory.close();
		}
		
		System.out.println("Exiting Programme......");
	}
}
