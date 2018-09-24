package jaraws.hibernate.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("TWO_WHEELER") // Not required here
public class TwoWheeler extends Vehicle {

	private String stearingHandle;

	public String getStearingHandle() {
		return stearingHandle;
	}

	public void setStearingHandle(String stearingHandle) {
		this.stearingHandle = stearingHandle;
	}
	
	
}
