package cab.system.error.mapping;

public enum CabSystemMessageEnum {
	
	ENTER_DETAILS(0,"Enter detils"),
	SYSTEM_DOWN(1,"Servie not available"),
	NOT_AVAILABLE(2,"Cab not available"),
	INVALID_REQUST(3,"You have made an invalid request. Please try again."),
	AVAILABLE(4,"Request processed successfully");
	

	private int code;
	private String description;
	
	CabSystemMessageEnum(int code, String description){
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	
}
