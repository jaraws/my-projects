package jaraws.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * If the discriminator value is not defined then Hibernate
 * will pick up the class name.
 * 
 * @author SWARAJ
 */
@Entity
@DiscriminatorValue("FOUR_WHEELER")
public class FourWheeler extends Vehicle {

	private String stearingWheel;

	public String getStearingWheel() {
		return stearingWheel;
	}

	public void setStearingWheel(String stearingWheel) {
		this.stearingWheel = stearingWheel;
	}
}
