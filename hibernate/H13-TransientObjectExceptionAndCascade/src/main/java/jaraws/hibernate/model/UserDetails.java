package jaraws.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Defining this UserDetail class as an Entity class i.e a separate table in the
 * database will be created by Hibernate in database for this entity.
 * 
 * @author Swaraj
 *
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;

	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_DETAILS_VEHICLE",
		joinColumns= {@JoinColumn(name="USER_ID")},
		inverseJoinColumns= {@JoinColumn(name="VEHICLE_ID")}
	)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public UserDetails() {

	}

	public int getId() {
		return id;
	}	

	public void setId(int id) {
		this.id = id;
	}

	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append("]");
		return builder.toString();
	}

	
	public void addVehicle(Vehicle vc1) {
		this.vehicle.add(vc1);
		//vc1.getUserDetail().add(this);
	}

}
