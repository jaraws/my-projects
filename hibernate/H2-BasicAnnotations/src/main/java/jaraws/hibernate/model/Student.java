package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is an Entity class.
 * 
 * @Column annotation could be placed over instance variable and over getter methods. 
 * While having @Column annotation over instance variable, Hibernate picks up the
 * value from the instance variable. However, if @Column annotation is placed over getter 
 * method, then Hibernate reads the instance variable value using its respective 
 * getter method.
 * 
 * @author Swaraj
 *
 */

/*
 * The property 'name' of the @Entity could be used to give the table name, but at the same time it also 
 * gives a name to the entity itself in the Hibernate context. So, here in this example the name of the entity 
 * and its corresponding table would be 'STUDENT_DETAIL'.
 */
@Entity(name="STUDENT_DETAIL") // Controlling the table name with Entity	
public class Student {
	
	@Id
	@Column(name="USER_ID")
	private String id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="age")
	private int age;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
}
