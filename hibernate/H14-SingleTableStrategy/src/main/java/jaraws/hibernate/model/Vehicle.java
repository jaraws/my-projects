package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * It is not necessary to declare single table strategy as
 * this is the default strategy followed by Hibernate.
 * 
 * @author Swaraj
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="VEHICLE_DISCRIMINATOR", // The default name given by Hibernate to discriminatory column is DTYPE, we can give this column a name as shown
		discriminatorType=DiscriminatorType.STRING
)
@Table(name="VEHICLE")
@DiscriminatorValue("VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;

	
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
