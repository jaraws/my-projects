package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Swaraj
 *
 */
@Entity
@Table(name="VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	
	//@ManyToOne(cascade=CascadeType.ALL,targetEntity=UserDetails.class) 
	//private Collection<UserDetails> userDetail = new ArrayList<UserDetails>();
	
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	

	/*public Collection<UserDetails> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(Collection<UserDetails> userDetail) {
		this.userDetail = userDetail;
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [vehicleId=");
		builder.append(vehicleId);
		builder.append(", vehicleType=");
		builder.append(vehicleType);
		/*
		 * This has been commented to prevent the stack flow error via toString method of 
		 * entities as both are referring to each other.
		 */
		//builder.append(", user="); 
		//builder.append(user);
		builder.append("]");
		return builder.toString();
	}
}
