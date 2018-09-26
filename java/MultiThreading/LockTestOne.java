import java.util.concurrent.locks.*;
import java.util.*;

/*
*	Eg: lock.lock();
*	The thread waiting to acquire the lock could NOT be interrupted. The Interrupted exception thrown by this program is when
*	thread t2 was sleeping and it was interrupted.
*/


class TestThreadOne extends Thread{
	
	Lock lock;
	
	TestThreadOne(Lock lock,String t){
		super(t);
		this.lock = lock;
	}
	public void run(){
		System.out.println("Thread "+this.getName()+" started");
		try{
			lock.lock();
			// access shared resource
			Thread.currentThread().sleep(10000);
			System.out.println("Thread "+Thread.currentThread().getName()+" accessing shared resource");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		System.out.println("Thread "+Thread.currentThread().getName()+" exiting");
	}
}

public class LockTestOne{

	public static void main(String abc[]){
	
		// Create a Semaphore with default fairness parameter i.e. false
		Lock lock = new ReentrantLock();
	
		TestThreadOne t1 = new TestThreadOne(lock,"t1");
		t1.start();
		try{
			Thread.currentThread().sleep(1000);
		}catch(Exception e){
			
		}
		TestThreadOne t2 = new TestThreadOne(lock,"t2");
		t2.start();
		
		t2.interrupt();
	}
}

