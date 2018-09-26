import java.io.*;

/*
	We can not catch a checked or IOException if it can't be thrown by a code execution
*/
class IOExceptionTest{

	void throwException(){
	}
	public static void main(String ags[])throws Exception{
		
		try{
			IOExceptionTest it = new IOExceptionTest();
		}catch(IOException e){
			
		}
	}
}