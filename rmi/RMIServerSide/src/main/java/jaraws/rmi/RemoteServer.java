package jaraws.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * 
 * 
 * RMI services need to be hosted in some server process. 
 * The Naming class provides methods to get and store the remote object. 
 * The Naming class provides 5 methods.
 * 
 * 1. public static java.rmi.Remote lookup(java.lang.String) throws java.rmi.NotBoundException, java.net.MalformedURLException, java.rmi.RemoteException; it returns the reference of the remote object.
 * 2. public static void bind(java.lang.String, java.rmi.Remote) throws java.rmi.AlreadyBoundException, java.net.MalformedURLException, java.rmi.RemoteException; it binds the remote object with the given name.
 * 3. public static void unbind(java.lang.String) throws java.rmi.RemoteException, java.rmi.NotBoundException, java.net.MalformedURLException; it destroys the remote object which is bound with the given name.
 * 4. public static void rebind(java.lang.String, java.rmi.Remote) throws java.rmi.RemoteException, java.net.MalformedURLException; it binds the remote object to the new name.
 * 5. public static java.lang.String[] list(java.lang.String) throws java.rmi.RemoteException, java.net.MalformedURLException; it returns an array of the names of the remote objects bound in the registry.
 * 
 * @author Swaraj
 *
 */
public class RemoteServer {

	public static void main(String args[]){
		
		
		try {
			RemoteInterface rImpl =  new RemoteInterfaceImpl();
			//Binding the remote object with name addService
			Naming.rebind("rmi://localhost:5000/addService",rImpl); 

		} catch (RemoteException e) {
			e.printStackTrace();
		}catch (MalformedURLException e){
			e.printStackTrace();
		} 
		
		
	}
}
