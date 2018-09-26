import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/*
	The first things you want to check are the two cases :
	
	1. Be careful not to submit new tasks after having called shutdown() on the Executor.
	2. Do not give the Executor more tasks than he can handle.
	
	Not surprisingly, the second case can be easily resolved. You could just use a data structure that does not impose a size limit. For example a LinkedBlockingQueue. So if you still face this problem after using LinkedBlockingQueue, you should focus on the first case. If the first case is not the cause of your problem, then you should probably look for more complex problem. For example, your memory is filling up because some of your threads have deadlocked and the LinkedBlockingQueue keeps filling up, and don’t forget is still the limit of the available memory that the JVM has.
*/
class Worker implements Runnable {

	int id;
	String name="Worker";
	
	public Worker(int id)
	{
		this.id=id;
		System.out.println("Worker "+id+" Created");
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread curThread = Thread.currentThread(); 
		try{
	            name=curThread.getName();
				System.out.println(name + " Executing " + id);
	            Thread.sleep(1000);
	            System.out.println(name + " Completed " + id);
	        }
	     catch(Exception e){
	     System.out.println(e.getMessage());
	         }
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s=name+" ID: "+id;
		return s;
	}
}


/*
	This RejectedExecutionHandler interface acts as a “callback” interface and it is called when the thread pool executor is unable to execute a task.
*/
class MyRejectedExecutionHandler implements RejectedExecutionHandler {	

	@Override
	public void rejectedExecution(Runnable worker, ThreadPoolExecutor executor) {
	
		// Any other approach could also be used depending on the requirement to handle the rejected tasks
		System.out.println(worker.toString()+" is Rejected");
		
	}
}



public class RejectedExecutionHandlerExample{
	
	public static void main(String args[]) throws Exception{		
			/*
			ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler)
			*/
			int corePoolSize=1;
			int maxPoolSize=2;
			long keepAliveTime = 1;
			TimeUnit unit =TimeUnit.SECONDS;
			BlockingQueue workQueue =  new ArrayBlockingQueue<Task>(10);

			MyRejectedExecutionHandler rejectedExecutionHandler =  new MyRejectedExecutionHandler();
			ThreadPoolExecutor executorService = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,workQueue,rejectedExecutionHandler);
			
			for(int i=1;i<50;i++){
				executorService.execute(new Worker(i));
			}
			
			executorService.shutdown();
			
			if(!executorService.isTerminated() && executorService.awaitTermination(10,TimeUnit.SECONDS)){
				System.out.println("Executor service successfully terminated");
			}else{
				if(!executorService.isShutdown()){
					System.out.println("Forcefully shutting down executorService..");
					executorService.shutdownNow();
				}	
			}

	}
}