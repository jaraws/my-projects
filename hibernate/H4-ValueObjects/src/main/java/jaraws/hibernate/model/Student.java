package jaraws.hibernate.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Defining this Student class as an Entity class i.e a separate table in the
 * database will be created by Hibernate in database for this entity.
 * 
 * @author Swaraj
 *
 */
@Entity
@Table(name = "STUDENT")
public class Student {

	/*
	 * These are following steps carries out by hibernate while
	 * managing the Id generation by itself.
	 *  
	 * 1. drop table if exists hibernate_sequence
	 * 2. create table hibernate_sequence (next_val bigint);
	 * 3. select next_val as swaraj from hibernate_sequence for update;
	 * 4. update hibernate_sequence set next_val= 3 where next_val=2;
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private int age;

	/*
	 * Embedding Value object in Entity object
	 */
	@Embedded
	private Address tempAddress;

	/*
	 * Overriding attributes for permanent address to prevent conflicts between the
	 * column names for temporary address and permanent address.
	 */
	@Embedded
	@AttributeOverrides({ 
			@AttributeOverride(name = "houseNo", column = @Column(name = "PERM_HOUSE_NUMBER")),
			@AttributeOverride(name = "street1", column = @Column(name = "PERM_STREET_1")),
			@AttributeOverride(name = "city", column = @Column(name = "PERM_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "PERM_STATE")),
			@AttributeOverride(name = "pinCode", column = @Column(name = "PERM_PIN_CODE")) })
	private Address permAddress;

	public Address getTempAddress() {
		return tempAddress;
	}

	public void setTempAddress(Address tempAddress) {
		this.tempAddress = tempAddress;
	}

	public Address getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(Address permAddress) {
		this.permAddress = permAddress;
	}

	public Student() {

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", age=").append(age).append(", tempAddress=").append(tempAddress)
				.append(", permAddress=").append(permAddress).append("]");
		return builder.toString();
	}

}
