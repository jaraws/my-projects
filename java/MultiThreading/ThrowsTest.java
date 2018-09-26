
import java.sql.SQLException;
import java.io.IOException;

class ThrowsTest{

	void show() throws IOException{
		
		// We can specify a checked exception in throws clause even if the method is not throwing it
	}
	
	void showOne(){
		try{
			
		}catch(IOException e){
			
		}
		
	}
}
