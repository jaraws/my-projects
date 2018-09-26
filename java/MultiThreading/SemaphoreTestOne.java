import java.util.concurrent.*;
import java.util.*;

/*
*	Program tests basic functions of Semaphore
*/
class TestThreadOne extends Thread{
	
	Semaphore sem;
	
	TestThreadOne(Semaphore sem){
		this.sem = sem;
	}
	public void run(){
		
	}
}

class TestThreadTwo extends Thread{
	
	Semaphore sem;
	
	TestThreadTwo(Semaphore sem){
		this.sem = sem;
	}
	
	public void run(){
		
	}
}

class SemaphoreTestOne{

	public static void main(String abc[]){
	
		// Create a Semaphore with default fairness parameter i.e. false
		Semaphore sem = new Semaphore(1);
		System.out.println("Semaphore: available permits: "+sem.availablePermits());
		System.out.println("Semaphore: isFair: "+sem.isFair());
		System.out.println("Semaphore: hasQueuedThreads: "+sem.hasQueuedThreads());		
		System.out.println("Semaphore: getQueueLength: "+sem.getQueueLength());	
		
		TestThreadOne t1 = new TestThreadOne(sem);
		t1.start();
		TestThreadTwo t2 = new TestThreadTwo(sem);
		t2.start();
	}
}

