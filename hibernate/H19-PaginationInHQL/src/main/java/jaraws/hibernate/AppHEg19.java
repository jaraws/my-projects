package jaraws.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jaraws.hibernate.model.UserDetails;

/**
 * Hello world!
 *
 */
public class AppHEg19 
{
	private static final Logger logger   = LoggerFactory.getLogger(AppHEg19.class);

	private static SessionFactory sessionFactory;
	
	static {
		/*
		 * Loading the data statically
		 */
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

		UserDetails ud5 = new UserDetails();
		ud5.setUserName("john");
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			
			session.save(ud1);
			session.save(ud2);
			session.save(ud3);
			session.save(ud4);
			session.save(ud5);
			
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
	
    public static void main( String[] args )
    {
    	Session session = null;
		Transaction txn =null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery("from UserDetails");
			 /* 
			  * This below statement will return the data starting from index 2 where the
			  * index of elements starts from value 0.
			  */
			query.setFirstResult(2);
			query.setMaxResults(2); // This will fetch exactly 2 records from the table
			List<UserDetails> users = (List<UserDetails>) query.list();
			
			txn.commit();
			
			users.stream().forEach(ud->{
				System.out.println(ud);
			});
		}catch (Exception e) {
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
		
		
    }
}
