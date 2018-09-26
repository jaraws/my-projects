package jaraws.rmi;

import java.rmi.Naming;

/**
 * Hello world!
 *
 */
public class ClientApp 
{
    public static void main( String[] args ){
    	
    	try{  
    		RemoteInterface stub=(RemoteInterface)Naming.lookup("rmi://localhost:5000/addService"); 	 
    		System.out.println(stub.add(34,40));  
    	}catch(Exception e){ 
    		e.printStackTrace();
    	}  
    }
}