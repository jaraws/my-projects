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
public class AppHEg20{
	private static final Logger logger   = LoggerFactory.getLogger(AppHEg20.class);

	// static block is defined after main method to populate the data in database
	
	private static SessionFactory sessionFactory;
	
    public static void main( String[] args )
    {
    	Session session = null;
		Transaction txn =null;
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			/*
			 * Following commented is an example of sql injection
			 * String uid =  "2 or 1 =1";
			 * Query query = session.createQuery("from UserDetails where id >" + uid );
			 * List<UserDetails> users = (List<UserDetails>) query.list();
			 * 
			 */
			// ? is the placeholder here, to specify where the parameter value has to go.
			Query query = session.createQuery("from UserDetails where id > ? and userName = ?");
			query.setInteger(0, 2); // 1st parameter, the first argument represent the index value of ? mark character 
			query.setString(1, "suzan"); // 2nd parameter
			List<UserDetails> users = (List<UserDetails>) query.list();
			users.stream().forEach(ud->{
				System.out.println(ud);
			});
			System.out.println("--------------------------------");
			
			// There is another way where we can give a more meaningful name to the place holder
			query = session.createQuery("from UserDetails where id > :userId and userName = :userName");
			query.setInteger("userId", 2); // 1st parameter, the first argument represent the index value of ? mark character 
			query.setString("userName", "suzan"); // 2nd parameter
			users = (List<UserDetails>) query.list();
			
			
			
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
}
