package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Address class is a Value Type which has no identity in itself. Such types
 * are know as Embeddable type and are defined by means of @Embeddable annotation. 
 * Hibernate does not create a separate class for an Value Type or Embeddable class
 * in database.
 * 
 * However, for an Entity class a Hibernate create a separate table in the database.
 * 
 * 
 * @author Swaraj
 *
 */
@Embeddable
public class Address {

	@Column(name = "HOUSE_NUMBER")
	private int houseNo;
	@Column(name = "STREET_1")
	private String street1;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PIN_CODE")
	private int pinCode;

	public Address() {

	}

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [houseNo=");
		builder.append(houseNo);
		builder.append(", street1=");
		builder.append(street1);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pinCode=");
		builder.append(pinCode);
		builder.append("]");
		return builder.toString();
	}

}
