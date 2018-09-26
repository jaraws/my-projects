package cab.system.view;

import java.util.Scanner;

import cab.system.context.CabSystemContext;
import cab.system.context.CabSystemContextWrapper;

public class CabSystemView {

	private static Scanner scanner = new Scanner(System.in);

	
	public CabSystemContext getInputs() {
			
		CabSystemContext cabSystemContext =  CabSystemContextWrapper.getCabSystemContext();
		
		if(cabSystemContext.isError()){
			System.out.println("------------------------------------");
			System.out.println(cabSystemContext.getErrorMessage()+": ");
			System.out.println("------------------------------------");
		}
		
		System.out.println("\nPlease enter the correct details: ");
		
		
		System.out.println("Enter Your Name:");
		cabSystemContext.setName(scanner.nextLine());
		
		System.out.println("Enter Pick Up Point:");
		cabSystemContext.setPickUpPoint(scanner.nextLine());
		
		System.out.println("Enter Drop Point:");
		cabSystemContext.setDropPoint(scanner.nextLine());
		
		System.out.println("Enter Age:");
		cabSystemContext.setAge(""+scanner.nextLine());
		
		System.out.println("Enter City:");
		cabSystemContext.setCity(scanner.nextLine());
		
		return cabSystemContext;
	}


	public void sendResponse() {
		CabSystemContext cabSystemContext =  CabSystemContextWrapper.getCabSystemContext();
		
		System.out.println("------------------------------------");
		System.out.println(cabSystemContext.getErrorMessage()+": ");
		System.out.println("------------------------------------");
	}

}
