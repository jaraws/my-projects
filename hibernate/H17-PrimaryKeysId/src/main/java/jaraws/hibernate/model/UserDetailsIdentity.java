package jaraws.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "USER_DETAILS_IDENTITY")
public class UserDetailsIdentity {

	/**
	 * Identity strategy is used with databases which supports Identity columns, which are highly
	 * optimized in terms of data base.
	 * The only drawback is that we can’t know the newly assigned value prior to executing the 
	 * INSERT statement. This restriction is hindering the “transactional write behind” flushing 
	 * strategy adopted by Hibernate. For this reason, Hibernates disables the JDBC batch support 
	 * for entities using the IDENTITY generator.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
