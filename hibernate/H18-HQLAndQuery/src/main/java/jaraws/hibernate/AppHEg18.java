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
public class AppHEg18{
	
	private static final Logger logger   = LoggerFactory.getLogger(AppHEg18.class);

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
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			// Instead of using the table name we are using the class name here.
			query = session.createQuery("from UserDetails"); // In HQL we mention the class names
			list = query.list();
			list.stream().forEach(ud->{
				// Following is as example from log back place holders
				logger.info("------>{}:{}:{}",ud,ud.getUserId(),ud.getUserName());
			});
			
			System.out.println("**********************************************************************");
			System.out.println("**********************************************************************");
			
			// Instead of using the column name we use the property name here
			query = session.createQuery("from UserDetails where userId > 2"); // In HQL we mention the class names
			list = query.list();
			list.stream().forEach(ud->{
				// Following is as example from log back place holders
				logger.info("------>{}:{}:{}",ud,ud.getUserId(),ud.getUserName());
			});
			
			
			System.out.println("**********************************************************************");
			System.out.println("**********************************************************************");
			
			// Instead of using the column name we use the property name here
			query = session.createQuery("from UserDetails ud where ud.userId <= 2"); // In HQL we mention the class names
			list = query.list();
			list.stream().forEach(ud->{
				// Following is as example from log back place holders
				logger.info("------>{}:{}:{}",ud,ud.getUserId(),ud.getUserName());
			});
			
			System.out.println("**********************************************************************");
			System.out.println("**********************************************************************");
			
			// Following example represents a scenario where you can select a specific columns to get the data
			query = session.createQuery("select userName from UserDetails"); // In HQL we mention the class names
			List<String> list1 = query.list();
			list1.stream().forEach(userName->{
				// Following is as example from log back place holders
				logger.info("1------>{}",userName);
			});
			
			System.out.println("**********************************************************************");
			System.out.println("**********************************************************************");
			
			// Following example represents a scenario where you can select n specific columns to get the data
			// In the following example hibernate will return a list of list
			// Where every internal list will represent a row corresponding to a row in database.
			query = session.createQuery("select userId,userName from UserDetails"); // In HQL we mention the class names
			List<?> list2 = query.list();
			list2.stream().forEach(wrapperList->{
				// Following is as example from log back place holders
				logger.info("2------>{}",wrapperList);
			});
			
			System.out.println("**********************************************************************");
			System.out.println("**********************************************************************");
			
			// Following example represents a scenario where you can select n specific columns to get the data
			// In the following example hibernate will return a list of map
			// Where every internal map will represent a row corresponding to a row in database.
			query = session.createQuery("select new map(userId,userName) from UserDetails"); // In HQL we mention the class names
			List<?> list3 = query.list(); // This will always end up in a list which could be an entity, list or a map etc.
			list2.stream().forEach(wrappedMap->{
				// Following is as example from log back place holders
				logger.info("3------>{}",wrappedMap);
			});
			
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
