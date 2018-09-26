import java.net.SocketException;
import java.sql.SQLException;

class SuperClass{

	void show() throws SocketException{
		
	}
}

public class SubClass extends SuperClass{

	void show() throws SQLException{
	
	}
	
	public static void main(String args[]){
	
		try{
			SuperClass sc = new SubClass();
			sc.show();
		}catch(SocketException se){
			
		}
		
	}
}