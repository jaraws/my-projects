import java.util.concurrent.*;
import java.util.*;

/*
*	Program tests basic functions of Semaphore and shows how the available permits gets reduced/increased as
*	threads invoke release() and acquire() method. 
*/

class Database{
	
	static void readData(){
		System.out.println("Thread "+Thread.currentThread().getName()+" accessing critical resource");
		try{
			Thread.currentThread().sleep(3000);
		}catch(Exception e){
			
		}
		System.out.println("Thread "+Thread.currentThread().getName()+" releasing critical resource");
	}
}
class TestThreadOne extends Thread{
	
	Semaphore sem;
	
	TestThreadOne(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		System.out.println("Thread "+Thread.currentThread().getName()+" started");
		try{
			// acquire permit before accessing critical resource
			sem.acquire();
			Database.readData();
			sem.release();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class TestThreadTwo extends Thread{
	
	Semaphore sem;
	
	TestThreadTwo(Semaphore sem){
		this.sem = sem;
	}
	
	public void run(){
		System.out.println("Thread "+Thread.currentThread().getName()+" started");
		try{
			// acquire permit before accessing critical resource
			sem.acquire();
			Database.readData();
			sem.release();
		}catch(Exception e){
			e.printStackTrace();
		}
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

public class SemaphoreTestTwo{

	public static void main(String abc[]){
	
		// Create a Semaphore with default fairness parameter i.e. false
		Semaphore sem = new Semaphore(1);
		
		new SemaphoreMonitor(sem).start();
	
		TestThreadOne t1 = new TestThreadOne(sem);
		t1.start();
		TestThreadTwo t2 = new TestThreadTwo(sem);
		t2.start();		
	}
}

