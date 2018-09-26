package cab.system.executor;

import java.util.concurrent.Callable;

import cab.system.context.CabSystemContext;
import cab.system.error.mapping.CabSystemMessageEnum;

public class BookingTask implements Callable<CabSystemContext>{

	CabSystemContext context;
	
	public BookingTask(CabSystemContext context){
		this.context = context;
	}
	
	@Override
	public CabSystemContext call() throws Exception {
		
		System.out.println("Executing the submitted task....");
		
		context.setErrorCode(CabSystemMessageEnum.AVAILABLE.getCode());
		context.setErrorMessage(CabSystemMessageEnum.AVAILABLE.getDescription());

		return context;
	}

}
