/*
	This program is written to test the difference between Volatile and Atomic classes in java.
	
	Volatile: Doesn't gurantees excluive read and write operation i.e. that is for a compount operation like i++ or i=i+1; this is 
			  quite possible that value of i before getting incremented is updated by some other thread, resulting in a wrong resulting	
			  incremente result of i=i+1 operation.
			  
			  Output: (Thread priniting out same values, implies access is not exclusive to the volatile variable)
			  =======
				Thread: Thread-1 volatileInt value: 221
				Thread: Thread-0 volatileInt value: 221
				Thread: Thread-0 volatileInt value: 222
				Thread: Thread-1 volatileInt value: 222

	Atomic (Integer/boolean/long): Gurantees the exclusive read and write operation i.e both read and write are mutually exclusive here.
			
			  Output: (Thread priniting out different values, implies access is not exclusive to the volatile variable)
			=========
				Thread: Thread-0 atomicInt value: 0
				Thread: Thread-1 atomicInt value: 1
				Thread: Thread-0 atomicInt value: 2
				Thread: Thread-1 atomicInt value: 3
				Thread: Thread-1 atomicInt value: 4
*/

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

class TestThreadOne extends Thread{
	
	private TestAtomicity testAtomicity;
	
	TestThreadOne(TestAtomicity testAtomicity ){
		this.testAtomicity= testAtomicity;
	}
	
	public void run(){
		
		try{
			int i = -1;
			do{
					testAtomicity.volatileInt = testAtomicity.volatileInt+1;
					System.out.println("Thread: "+this.getName()+" volatileInt value: " +testAtomicity.volatileInt);
					Thread.currentThread().sleep(2000);
				}while(i<500);
		}catch(Exception e){
			
		}
	}
}

class TestThreadTwo extends Thread{
	
	private TestAtomicity testAtomicity;

	
	TestThreadTwo(TestAtomicity testAtomicity ){
		this.testAtomicity= testAtomicity;
	}
	
	public void run(){
		try{
				int i = -1;
				do{
					testAtomicity.volatileInt = testAtomicity.volatileInt+1;
					System.out.println("Thread: "+this.getName()+" volatileInt value: " +testAtomicity.volatileInt);
					Thread.currentThread().sleep(2000);
				}while(i<500);
		}catch(Exception e){
		
		}
	}
}

class TestThreadThree extends Thread{
	
	private TestAtomicity testAtomicity;
	
	TestThreadThree(TestAtomicity testAtomicity ){
		this.testAtomicity= testAtomicity;
	}
	
	public void run(){
		
		try{
			int i = -1;
			do{
					int value = testAtomicity.atomicInt.getAndIncrement();
					System.out.println("Thread: "+this.getName()+" atomicInt value: " +value);
					Thread.currentThread().sleep(2000);
				}while(i<500);
		}catch(Exception e){
			
		}
	}
}

class TestThreadFour extends Thread{
	
	private TestAtomicity testAtomicity;
	
	TestThreadFour(TestAtomicity testAtomicity ){
		this.testAtomicity= testAtomicity;
	}
	
	public void run(){
		
		try{
			int i = -1;
			do{
					int value = testAtomicity.atomicInt.getAndIncrement();
					System.out.println("Thread: "+this.getName()+" atomicInt value: " +value);
					Thread.currentThread().sleep(2000);
				}while(i<500);
		}catch(Exception e){
			
		}
	}
}
class TestAtomicity{
	
	protected volatile int volatileInt;
	protected AtomicInteger atomicInt;
	
	public TestAtomicity(){
		volatileInt = 0;
		atomicInt = new AtomicInteger();
	}
	

	public static void main(String args[]) throws Exception{
		
		TestAtomicity testAtomicity = new TestAtomicity();
		
		//(new TestThreadOne(testAtomicity)).start();
		//(new TestThreadTwo(testAtomicity)).start();
		(new TestThreadThree(testAtomicity)).start();
		(new TestThreadFour(testAtomicity)).start();

	}
}