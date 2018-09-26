package cab.system.bo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import cab.system.context.CabSystemContext;
import cab.system.context.CabSystemContextWrapper;
import cab.system.dao.CabSystemDao;
import cab.system.error.mapping.CabSystemMessageEnum;
import cab.system.executor.BookingTask;

public class CabSystemBOImpl implements CabSystemBO {

	private CabSystemDao dao = null;
	private ExecutorService executor = null;

	public CabSystemBOImpl(CabSystemDao cabSystemDao) {
		this.dao = cabSystemDao;

		int systemThroughut = 10000;
		int corePoolSize = 2;
		int scaleFactor = 1;
		int nop = Runtime.getRuntime().availableProcessors();
		int maxThreads = nop * scaleFactor;
		maxThreads = (maxThreads > 0) ? maxThreads : 1; // maxThreads can not be
														// zero

		System.out.println("nop: " + nop + " / maxThreads: " + maxThreads);
		executor = new ThreadPoolExecutor(corePoolSize, maxThreads, 2000,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(systemThroughut),
				new ThreadPoolExecutor.CallerRunsPolicy());
		

	}

	public void processRequest() throws Exception {

		CabSystemContext context = CabSystemContextWrapper
				.getCabSystemContext();

		
		if (dao.checkAvailability()) {

			System.out.println("Cab is avaibale...");
			// submit the request to the executor service
			BookingTask bt = new BookingTask(context);
			
			Future ft = executor.submit(bt);
			System.out.println("Received Future>>>> : "+ft.get());
			
		} else {
			context.setError(true);
			context.setErrorCode(CabSystemMessageEnum.NOT_AVAILABLE.getCode());
			context.setErrorMessage(CabSystemMessageEnum.NOT_AVAILABLE
					.getDescription());
		}
	}

}
