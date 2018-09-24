package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	/*
	 *  Creating a reverse relationship to identify who is the owner of this vehicle
	 */
	@ManyToOne
	// Just to rename the colum created by Hibernate in VEHICLE table to keep a reference of USER_DETAIL table
	@JoinColumn(name="USER_ID") 
	private UserDetails userDetail;
	
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

	
	

	public UserDetails getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetails userDetail) {
		this.userDetail = userDetail;
	}

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
		builder.append(", user="); 
		builder.append(userDetail!=null?"user-exists":null); // To avoid stack overflow as both the entities are holding reference to each other.
		builder.append("]");
		return builder.toString();
	}
}
