package jaraws.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private int age;

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
	 * Hibernate by itself will make an association of VEHICLE with USER_DETAILS by altering USER_DETAILS
	 * to have primary key of VEHICLE as foreign key of USER_DETAILS. 
	 * logs >> Hibernate: alter table USER_DETAILS add constraint FK208ur2wvrqhx4pwy7f4mcs4kk foreign key (VEHICLE_ID) 
	 * references VEHICLE (VEHICLE_ID)
	 * 
	 * NOTE: It is not mandatory that foreign key column in parent entity table and primary key column in
	 * child entity table should have the same name.
	 */
	
	//@OneToOne(cascade= {CascadeType.ALL},fetch=FetchType.EAGER) // Bases on the requirement, LAZY fetch is default
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	
	public UserDetails() {

	}

	public int getId() {
		return id;
	}	

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
}
