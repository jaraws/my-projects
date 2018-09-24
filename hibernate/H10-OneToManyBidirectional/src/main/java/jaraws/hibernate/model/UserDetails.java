package jaraws.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	/*
	 * Exception:
	 * Caused by: org.hibernate.TransientObjectException: object references an unsaved transient instance - 
	 * save the transient instance before flushing: jaraws.hibernate.model.Vehicle
	 * .......................
	 * .............
	 * 
	 * We should include cascade="all" (if using xml) or cascade=CascadeType.ALL (if using annotations) 
	 * on our collection/entity mapping. This happens because we have a collection/entity in our parent
	 * entity and that collection/entity has one or more items which are not present in the database. 
	 * By specifying the above options we tell Hibernate to save them to the database when saving their 
	 * parent.
	 * 
	 * NOTE: It is not mandatory that foreign key column in parent entity table and primary key column in
	 * child entity table should have the same name.
	 * 
	 * @OneToMany: Depicting that a USER_DETAILS can have multiple VEHICLE associated with it.
	 */
	
	/*
	 * NOTE: What Hibernate has generated here ?
	 * logs........
	 * Hibernate: create table USER_DETAILS (USER_ID integer not null, AGE integer, FIRST_NAME varchar(255), LAST_NAME varchar(255), primary key (USER_ID)) engine=MyISAM
	 * Hibernate: create table VEHICLE (ID integer not null, VEHICLE_COLUMN varchar(255), primary key (ID)) engine=MyISAM
 	 * Hibernate: create table USER_DETAILS_VEHICLE (UserDetails_USER_ID integer not null, vehicle_ID integer not null) engine=MyISAM
 	 * 
 	 * Hibernate has generated a 3rd table having primary column of both the USER_DETAILS and VEHICLE table to make this
 	 * join working. This table is also called JOIN TABLE.
 	 * 
 	 * @JoinTable: This annotation is just a reference to the Join table between entities. We have used it here, just to override
 	 * the default names given by the Hibernate to Join table and its columns as can be seen in Hibernate logs above.
 	 * 
 	 * If strategy FetchType.LAZY is used then we can see while retrieving the user details, select query is fired twice. Once for
 	 * reading the USER_DETAILS and second time to retrieve the second level instance i.e. VEHICLE here.  
	 */
	@OneToMany(fetch=FetchType.EAGER,cascade= {CascadeType.ALL})
	@JoinTable(
		name="USER_VEHICLE", // name of the join table created by hibernate to maintain Onr to many relationship
		joinColumns= {@JoinColumn(name="USER_ID")}, // joinColumns: to refer the columns from this entity i.e USER_DETAILS
		inverseJoinColumns= {@JoinColumn(name="VEHICLE_ID")}) //inverseJoinColumn: to refer the columns from other entity i.e. VEHICLE
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

	/*
	 * Helper method to add vehicle details to UserDetails and vice versa
	 */
	public void addVehicle(Vehicle vc1) {
		this.getVehicle().add(vc1);
		vc1.setUser(this); // Adding User to Vehicle for bidirectional relationship
	}

}
