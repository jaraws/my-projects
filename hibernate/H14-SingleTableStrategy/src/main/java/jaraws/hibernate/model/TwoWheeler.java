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
@DiscriminatorValue("TWO_WHEELER")
public class TwoWheeler extends Vehicle {

	private String stearingHandle;

	public String getStearingHandle() {
		return stearingHandle;
	}

	public void setStearingHandle(String stearingHandle) {
		this.stearingHandle = stearingHandle;
	}
	
	
}
