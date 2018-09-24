package jaraws.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jaraws.hibernate.model.FourWheeler;
import jaraws.hibernate.model.TwoWheeler;
import jaraws.hibernate.model.Vehicle;

/**
 * Hello world!
 *
 */
public class AppHEg14 
{
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		System.out.println("Inserting object ...");
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Transaction txn = null;
		@SuppressWarnings("unused")
		Vehicle vc = null;
		
		
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();

			// Creating an instance of Vehicle Entity type
			Vehicle vc1 = new Vehicle();
			vc1.setVehicleType("All Vehicles");
			
			// Creating an instance of Vehicle Entity type
			TwoWheeler tw1 = new TwoWheeler();
			tw1.setVehicleType("Bicycle");
			tw1.setStearingHandle("YES");
			
			// Creating an instance of Vehicle Entity type
			FourWheeler fw1 = new FourWheeler();
			fw1.setVehicleType("Car");
			fw1.setStearingWheel("YES");
			
			session.save(vc1);
			session.save(tw1); // saving the vehicle here will save the user as well because of cascadeType=ALL property
			session.save(fw1);
			//session.save(vc3);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
			sessionFactory.close();
		}
		System.out.println("Insert executed....");
		
	}
}
