package jaraws.rmi.readme;

public class ReadMe {

	/*
	 
	 1. The RMI (Remote Method Invocation) is an API that provides a mechanism to create 	
	 	distributed application in java. The RMI allows an object to invoke methods on an 
	 	object running in another JVM.

	 2. The RMI provides remote communication between the applications using two objects 
	 	stub and skeleton.
	 	
	 	
	 	Understanding stub and skeleton
	 	-----------------------------------

		RMI uses stub and skeleton object for communication with the remote object.
		
		A remote object is an object whose method can be invoked from another JVM. Let's 
		understand the stub and skeleton objects:
		
		stub
		-----
		The stub is an object, acts as a gateway for the client side. All the outgoing 
		requests are routed through it. It resides at the client side and represents the 
		remote object. When the caller invokes method on the stub object, it does the 
		following tasks:
		
		> It initiates a connection with remote Virtual Machine (JVM),
		> It writes and transmits (marshals) the parameters to the remote Virtual Machine (JVM),
		> It waits for the result
		> It reads (unmarshals) the return value or exception, and
		> It finally, returns the value to the caller.
		
		
		skeleton
		-------
		The skeleton is an object, acts as a gateway for the server side object. All the 
		incoming requests are routed through it. When the skeleton receives the incoming 
		request, it does the following tasks:
		
		> It reads the parameter for the remote method
		> It invokes the method on the actual remote object, and
		> It writes and transmits (marshals) the result to the caller.
			 
			 
			 
			 
		Steps to write the RMI program
		---------

		Here is given the 6 steps to write the RMI program.
		
		1. Create the remote interface
		2. Provide the implementation of the remote interface
		3. Compile the implementation class and create the stub and skeleton objects using the rmic tool
		4. Start the registry service by rmiregistry tool
		5. Create and start the remote application
		6. Create and start the client application
	 */
}
