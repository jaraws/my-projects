package jaraws.hibernate.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("FOUR_WHEELER")
public class FourWheeler extends Vehicle {

	private String stearingWheel;

	public String getStearingWheel() {
		return stearingWheel;
	}

	public void setStearingWheel(String stearingWheel) {
		this.stearingWheel = stearingWheel;
	}
}
