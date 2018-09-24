package jaraws.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "USER_DETAILS")
public class UserDetails {

	/*
	 * Hibernate will choose a default id generation strategy depending up the dialect used i.e.
	 * depending up on the database used by the application.
	 */
	@Id
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
