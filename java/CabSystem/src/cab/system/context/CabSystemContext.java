package cab.system.context;

/**
 * 
 * @author Swaraj
 *
 */
public class CabSystemContext {
	
	private int requestId;
	private String name;
	private String pickUpPoint;
	private String dropPoint;
	private String age;
	private String city;
	private boolean error;
	private int errorCode;
	private String errorMessage;
	
	
	public CabSystemContext(int userrequestid) {
		this.requestId = userrequestid;
	}
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPickUpPoint() {
		return pickUpPoint;
	}
	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String  age) {
		this.age = age;
	}
	
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "CabSystemContext [requestId=" + requestId + ", name=" + name
				+ ", pickUpPoint=" + pickUpPoint + ", dropPoint=" + dropPoint
				+ ", age=" + age + ", city=" + city + ", error=" + error
				+ ", errorCode=" + errorCode + ", errorMessage=" + errorMessage
				+ "]";
	}

	public void resetErrorFlags() {

			this.error=false;
			this.errorCode  =  -1;
			this.errorMessage = null;
	}
	
	
}
