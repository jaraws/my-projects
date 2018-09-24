package jaraws.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @Embaddable denotes that this class is
 * owned by some other entity i.e. Student
 * here.
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
