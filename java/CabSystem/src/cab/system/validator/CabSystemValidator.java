package cab.system.validator;

import cab.system.context.CabSystemContext;
import cab.system.context.CabSystemContextWrapper;
import cab.system.error.mapping.CabSystemMessageEnum;


public class CabSystemValidator {

		public void validateUserInputs(){
			
			CabSystemContext context = CabSystemContextWrapper.getCabSystemContext();
			
			try{
				Integer.parseInt(context.getAge());
				context.resetErrorFlags();

			}catch(Exception e){
				context.setError(true);
				context.setErrorCode(CabSystemMessageEnum.INVALID_REQUST.getCode());
				context.setErrorMessage(CabSystemMessageEnum.INVALID_REQUST.getDescription());
			}

		}
}
