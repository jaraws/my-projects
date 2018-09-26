
/**

	This examples illutrates the sequence in which different class blocks are executed
	when a class is instantiated.
	
	@author: swaraj
**/
class SuperClassBlockExecution{
	
	private static int superStaticInt = 1;
	private int superInstanceInt = 2;
	
	{
		System.out.println("Super>> Instance Initialization block executed: "+superInstanceInt);		
	}

	SuperClassBlockExecution(){
		System.out.println("Super>> Constructor executed");		
	}

	static{
		System.out.println("Super>> Static Initialization block executed: "+ superStaticInt);		
	}
}
public class ClassBlockExecution extends SuperClassBlockExecution{

	private static int staticInt = 3;
	private int instanceInt = 4;
	{
		System.out.println("Instance Initialization block executed: "+instanceInt);		
	}

	ClassBlockExecution(){
		System.out.println("Constructor executed");		
	}

	static{
		System.out.println("Static Initialization block executed: "+ staticInt);		
	}
	
	public static void main(String ... a){
	
		ClassBlockExecution objClassBlockExecution =  new ClassBlockExecution();
		
		System.out.println("Block executions sequence is as follows: ");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		System.out.println("Super>> Static variables are initialized");
		System.out.println("Super>> Static initialization block executed");
		
		System.out.println("Sub>> Static variables are initialized");
		System.out.println("Sub>> Static initialization block executed");
		
		System.out.println("Super>> Instance variables are initialised");
		System.out.println("Super>> Instance initialization block executed");
		System.out.println("Super>> Constructor executed");
		
		System.out.println("Sub>> Instance variables are initialised");
		System.out.println("Sub>> Instance initialization block executed");
		System.out.println("Sub>> Constructor executed");
		System.out.println("-------------------------------------------");
		System.out.println("-------------------------------------------");
		System.out.println("Main method exiting..");
	}
}