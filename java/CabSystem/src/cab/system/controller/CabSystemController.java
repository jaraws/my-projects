package cab.system.controller;

import java.util.Scanner;
import java.util.logging.Logger;

import cab.system.bo.CabSystemBO;
import cab.system.context.CabSystemContext;
import cab.system.context.CabSystemContextWrapper;
import cab.system.dao.CabSystemDao;
import cab.system.factory.CabSystemFactory;
import cab.system.validator.CabSystemValidator;
import cab.system.view.CabSystemView;

public final class CabSystemController {

	private static Logger logger = Logger.getLogger(CabSystemController.class.getName());
	private static CabSystemFactory cabSystemFactory = CabSystemFactory.getCabSystemFactory();
	
	private static CabSystemView view = cabSystemFactory.getCabSystemView(); 
	private static CabSystemValidator validator = cabSystemFactory.getCabSystemValidator();
	private static CabSystemBO bObject = cabSystemFactory.getCabSystemBO();
	
	
	static{
		logger.info("Initialising CabSystemController..");
	}


	
	public static void main(String args[]){
	
		Scanner sc = new Scanner(System.in);
		do{
			begin();
			System.out.println("Pres Y to continue: ");
			String input = sc.nextLine();
			System.out.println(">>>"+input);
			if("Y".equalsIgnoreCase(input)){
				break;
			}
		}while(true);
		
		System.out.println("Exiting application ....");
	}

	private static void begin() {
		CabSystemContext context = null;
	
		// Generate a service token for this user context
		context = new CabSystemContext(cabSystemFactory.getUserrequestid());

		// Set the context in ThreadLocal
		CabSystemContextWrapper.setCabSystemContext(context);
		
		// Read input unless user enters the right input
		do{
			readUserInputs(); // read user inputs
			if(validateUserInputs()){
				break;
			}
		}while(true);

		// process user request
		processRequest();
		
		//ResponseUser
		sendResponse();
		
		// Send confirmation message
		sendMessage();
		
		logger.info(context.toString());
	}

	private static void sendMessage() {
		// TODO Auto-generated method stub
		
	}

	private static void sendResponse() {
		view.sendResponse();
	}

	private static void processRequest() {
		try {
			bObject.processRequest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readUserInputs() {
		view.getInputs();	
	}
	
	private static boolean validateUserInputs() {
		boolean isValidRequest = false;
		
		validator.validateUserInputs(); // validate user inputs
		
		isValidRequest = !CabSystemContextWrapper.getCabSystemContext().isError();
		return isValidRequest;
	}



}
