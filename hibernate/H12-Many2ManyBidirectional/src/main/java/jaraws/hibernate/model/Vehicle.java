package jaraws.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	 * The mappedBy attribute has been defined here to tell the hibernate
	 * that this mapping has been defined by userDetail of other UserDetails
	 * entity and it will not create the mapping table.
	 * 
	 * IMPORTANT
	 * ------------------------
	 * Removing mappedBy attribute will result in creation of 2 mapping tables:
	 * one from User_Details to Vehicle: [table --> User_Details_Vehicle]
	 * one from Vehicle to User_Details: [table --> Vehicle_User_Details]
	 */
	/*
	 * Not doing the mapping here because of mappedBy property, which has specified 
	 * Hibernate that this mapping is provided by vehicle of UserDetails i.e. other side
	 * of the association.
	 * 
	 * IMPORTANT
	 * --------------------------
	 * We also need to map the many-to-many association on the Vehicle entity to make it bidirectional.
	 * As we can see in the following code snippet, this is done in a similar way as on the UserDetails entity.
	 * We need an attribute that models the association and a @ManyToMany annotation.
	 * In this example, it’s the List userDetail attribute which we annotated with a @ManyToMany annotation. 
	 * The association is already defined on the UserDetails entity side. We can therefore just reference the attribute 
	 * on the UserDetails entity in the mappedBy attribute here and Hibernate will use the same definition.
	 */
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="vehicle")  // mapped by referring the association definition given in UserDetails entity.
	private Collection<UserDetails> userDetail = new ArrayList<UserDetails>();
	
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
	

	public Collection<UserDetails> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(Collection<UserDetails> userDetail) {
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
		//builder.append(", user="); 
		//builder.append(user);
		builder.append("]");
		return builder.toString();
	}
}
