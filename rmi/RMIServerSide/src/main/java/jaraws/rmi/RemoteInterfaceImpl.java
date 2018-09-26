package jaraws.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Provide the implementation of the remote interface. 
 * ----------------------------
 * For providing the implementation of the Remote interface, we need 
 * to either extend the UnicastRemoteObject class, or use the exportObject() 
 * method of the UnicastRemoteObject class
 * 
 * @author Swaraj
 *
 */
public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface {

	
	protected RemoteInterfaceImpl() throws RemoteException {
		super();
	}

	// Remote object method to be called remotely
	public int add(int a, int b) throws RemoteException {
		return a + b;
	}

}
