package jaraws.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * This class is an Entity class.
 * 
 * @Column annotation could be placed over instance variable and over getter
 *         methods. While having @Column annotation over instance variable,
 *         Hibernate picks up the value of instance variable. However,
 *         if @Column annotation is placed over getter method, then Hibernate
 *         reads the instance variable value using its respective getter method.
 * 
 * @author Swaraj
 *
 * @Clob is used for large Character objects and @Blob is used for large Byte stream of objects like arrays.
 *  Using only @Lob lets the Hibernate choose whether its a Character lob or a Byte Lob. 
 *  If @Lob is over a String property then Hibernate chooses CLOB for that property and if @Lob annotation is over an Array 
 *  object then Hibernate chooses the @Blob for that property.
 *  By default Hibernate reserves a space of 255 characters for a String property unless it is not explicitly defined as a 
 *  LOB i.e BLOB or CLOB
 *  
 *  @Transient - If an object field is transient, and it will not be associated with any of the Hibernate Session . 
 *  It has no persistent representation in the database. It simply indicates that a field is not to be persisted 
 *  in the database.
 */

/*
 * The property 'name' of the @Entity could be used to give the table name, but
 * at the same time it also gives a name to the entity itself in the Hibernate
 * context. So, here in this example the name of the entity  would be 'ClassDetail'
 * and its corresponding table would be known by name 'CLASS_DETAIL'.
 */
@Entity
@Table(name = "CLASS_DETAIL") // Using Table annotation to keep the Entity name intact
public class ClassDetail {

	/*
	 *  static properties are not persisted by Hibernate, as all the instances of Entity
	 *  class will share the same property value. Hence, therefore it doesn't make any 
	 *  sense to have a column for this field in table as every value of that column will be
	 *  same in the table.
	 *  
	 *  The same could be achieved by marking the property with annotation @Transient
	 */
	@SuppressWarnings("unused")
	private static Long UUID=1L;
	
	@Transient
	private String classTeacherId;
	
	@Id
	@Column(name = "CLASS_ID")
	private String id;

	@Column(name = "CLASS_NAME")
	private String className;

	@Column(name = "CLASS_SECTION")
	private String classSection;

	@Column(name = "CLASS_STRENGTH")
	private int strength; // number of students in the class
	
	@Column(name= "CLASS_ESTABLISED_ON")
	@Temporal(TemporalType.DATE) // To save only the date part of the entire time stamp[It supports TIMESTAMP,DATE and TIME]
	private Date establisedDate;
	
	@Column(name="CLASS_DESCRIPTION")
	@Lob 
	private String details;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public Date getEstablisedDate() {
		return establisedDate;
	}

	public void setEstablisedDate(Date establisedDate) {
		this.establisedDate = establisedDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClassDetail [classTeacherId=").append(classTeacherId).append(", id=").append(id)
				.append(", className=").append(className).append(", classSection=").append(classSection)
				.append(", strength=").append(strength).append(", establisedDate=").append(establisedDate)
				.append(", details=").append(details).append("]");
		return builder.toString();
	}
	
}
