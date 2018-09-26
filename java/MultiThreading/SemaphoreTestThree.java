import java.util.concurrent.*;
import java.util.*;

/*
*	It is not necessary for a thread that release a permit must have acquired a permit by calling acquire().
*   If a thread calls release() without invoking acquire() then the number of permits of a Semaphore will be
* 	increased by 1.
*/

class TestThreadOne extends Thread{
	
	Semaphore sem;
	
	TestThreadOne(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		System.out.println("Thread "+Thread.currentThread().getName()+" started");
		try{
			// releasing a permit where a Semaphore already have default number of permits will block the thread
			sem.release(10);
		}catch(Exception e){
			e.printStackTrace();
		}
	System.out.println("Thread "+Thread.currentThread().getName()+" exiting");
	}
}

class SemaphoreMonitor extends Thread{
	Semaphore sem;
	SemaphoreMonitor(Semaphore sem){
		this.sem = sem;
	}
	
	public void run(){
		
		while(true){
			try{
				System.out.println("==================");
				System.out.println("Monitor: available permits: "+sem.availablePermits());
				System.out.println("Monitor: isFair: "+sem.isFair());
				System.out.println("Monitor: hasQueuedThreads: "+sem.hasQueuedThreads());		
				System.out.println("Monitor: getQueueLength: "+sem.getQueueLength());	
				System.out.println("==================");
				this.sleep(5000);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
}

public class SemaphoreTestThree{

	public static void main(String abc[]){
	
		// Create a Semaphore with default fairness parameter i.e. false
		Semaphore sem = new Semaphore(1);
		
		new SemaphoreMonitor(sem).start();
	
		TestThreadOne t1 = new TestThreadOne(sem);
		t1.start();
		
	}
}

