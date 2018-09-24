package jaraws.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	 * Remove FetchType.EAGER to validate the LAZY loading behavior of Hibernate.
	 * 
	 * NOTE: This eager behavior is just for this 2nd level instance variable only i.e. 'listOfAddresses'.  
	 * Hibernate will still keep on lazily fetching other 2nd level instance variables. Hence, Hibernate always
	 * returns the proxy object of the entity class object no matter what value of parameter FetchType has been
	 * set, either EAGER or LAZY.
	 * 
	 * @JoinTable annotation is just to reference the join table and setting up its properties
	 */
	@ElementCollection(fetch=FetchType.EAGER) 
	//@CollectionTable(name = "student_addresses", joinColumns = @JoinColumn(name = "id"))
	@JoinTable(name="STUDENT_ADDRESS",
		joinColumns=@JoinColumn(name="STUDENT_ID")
	) // The join column which will be used by @JoinTable table will be created by name 'STUDENT_ID'
	private Collection<Address> listOfAddresses = new ArrayList<Address>();

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

	

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	/*@Override
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
	}*/
}
