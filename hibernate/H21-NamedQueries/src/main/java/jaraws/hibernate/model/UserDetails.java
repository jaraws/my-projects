package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The name of the named query should be given as <entity-name>.<noun identifying the work done by query>
 * 
 * @author SWARAJ
 *
 */
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId = :userId")
@NamedNativeQuery(name="UserDetails.byName", 
					query="select * from USER_DETAILS where user_name =:userName",
						resultClass=UserDetails.class)
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	public UserDetails() {
		super();
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
