import java.util.concurrent.*;
import java.util.*;

/*
*	If the current thread:
* 	a> has its interrupted status set on entry to this method; 
*	or
*	b> is interrupted while waiting for a permit,
*	then InterruptedException is thrown and the current thread's interrupted status is cleared. Any permits that were to be assigned to 	*	this thread are instead assigned to other threads trying to acquire permits, as if permits had been made available by a call to
*	release().
*/


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


class TestThreadOne extends Thread{
	
	Semaphore sem;
	
	TestThreadOne(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		System.out.println("Thread "+this.getName()+" started");
		try{
			System.out.println("If "+this.getName()+" thread interrupted: " +this.isInterrupted());
			//this.interrupt();
			Thread.currentThread().sleep(10000);
			System.out.println("If "+this.getName()+" thread interrupted: " +this.isInterrupted());
			// acquiring permit with interrupt status =true
			sem.acquire();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("If "+this.getName()+" thread interrupted: " +this.isInterrupted());
	System.out.println("Thread "+Thread.currentThread().getName()+" exiting");
	}
}

public class SemaphoreTestFive{

	public static void main(String abc[]){
	
		// Create a Semaphore with default fairness parameter i.e. false
		Semaphore sem = new Semaphore(1);
		
		new SemaphoreMonitor(sem).start();
	
		TestThreadOne t1 = new TestThreadOne(sem);
		t1.start();
		
		try{
			// sleeping for 3 seconds to let the thread t1 sleep for 10 seconds
			Thread.currentThread().sleep(3000);
			t1.interrupt();
		}catch(Exception e){
			
		}
	}
}

