package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * 
 * @author Swaraj
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
/*
 * Since, we are using table per class strategy, hence, discriminatory column will not be required to discriminate
 * the table records with each other.
 * @DiscriminatorColumn(
		name="VEHICLE_DISCRIMINATOR", // The default name given by Hibernate to discriminatory column is DTYPE, we can give this column a name as shown
		discriminatorType=DiscriminatorType.STRING
	)
 */
@Table(name="VEHICLE")
//@DiscriminatorValue("VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(generator="tblIdGenerator", strategy=GenerationType.TABLE) // default strategy will be used to generate the id
	@TableGenerator(name = "tblIdGenerator", initialValue=1, 
						pkColumnName="COUNT_VALUE", pkColumnValue="count",
							allocationSize=1,table="TBL_ID_GENERATOR",
							valueColumnName="VALUE")
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
