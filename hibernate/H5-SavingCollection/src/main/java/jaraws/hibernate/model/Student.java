package jaraws.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	 * These are following steps carries out by hibernate while managing the Id
	 * generation by itself.
	 * 
	 * 1. drop table if exists hibernate_sequence 2. create table hibernate_sequence
	 * (next_val bigint); 3. select next_val as swaraj from hibernate_sequence for
	 * update; 4. update hibernate_sequence set next_val= 3 where next_val=2;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int id;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "AGE")
	private int age;

	/*
	 * Here we are creating a collection of Address objects as we do not know that
	 * how many addresses a Student has lived. In order to achieve the same we are
	 * creating a Set of Address(s) objects inside Student object.
	 * 
	 * @ElementCollection: To mark this collection to be persisted by Hibernate as a
	 * Separate table,not as an Embedded table columns.
	 * 
	 * @JoinTable: It is used to refer the join table only which will be generated 
	 * corresponding to the Embeddable object. A separate table will be created 
	 * for the Embeddable object here as we are using @ElementCollection annotation here.
	 * Its name attribute is used to give a specific name for Embeddable object table.
	 * 
	 * @JoinTable: This table doesn't mentions that this Entity has to be joined with 
	 * some other Entity or Embeddable object. It is simply used to refer the Join table name
	 * i.e Address table here and could be used to update the table attributes. 
	 */
	@ElementCollection
	//@CollectionTable(name = "student_addresses", joinColumns = @JoinColumn(name = "id"))
	@JoinTable(name="STUDENT_ADDRESS",
		joinColumns=@JoinColumn(name="STUDENT_ID") // The join column which will be used by @JoinTable table will be created by name 'STUDENT_ID'
	) 
	private Set<Address> listOfAddresses = new HashSet<Address>();

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

	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", listOfAddresses=");
		builder.append(listOfAddresses);
		builder.append("]");
		return builder.toString();
	}
}
