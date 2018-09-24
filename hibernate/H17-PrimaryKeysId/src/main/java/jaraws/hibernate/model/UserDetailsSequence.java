package jaraws.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "USER_DETAILS_SEQUENCE")
public class UserDetailsSequence {

	/**
	 * @SequqnceGenerator annotation defines the sequence the sequence generator. The property allocation
	 * size determines the number of sequences to fetch from the data base in one execution of NEXT_VAL
	 * of the sequence. This will prevent Hibernate to the hit database to to get a sequence number on each
	 * save or persist operation. So, whenever a next persist will be called the next sequence value
	 * will be determined by adding 1 to the previous value of sequence used. So, in this example we shall be
	 * saving 49 round trips to the database.
	 */
	@Id
	@SequenceGenerator(name="user_det_seq",initialValue=1, sequenceName="user_detail_sequence",allocationSize=50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_det_seq")
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
