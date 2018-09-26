import java.util.concurrent.*;
import java.util.*;

/**
 This java program quotes a simple program to represt CyclicBarrier 
*/
class TestThreadOne extends Thread{
	
	CyclicBarrier cb;
	
	TestThreadOne(String name,CyclicBarrier cb){
		super(name);
		this.cb=cb;
	}
	
	public void run(){
		System.out.println("Begin Thread >>>>> "+Thread.currentThread().getName());
		try{
			System.out.println("cb.await(); >>>>> "+cb.await());
		}catch(Exception e){	
		}
		System.out.println("End Thread >>>>> "+Thread.currentThread().getName());
	}
}

class TestThreadTwo extends Thread{
	
	CyclicBarrier cb;
	
	TestThreadTwo(String name,CyclicBarrier cb){
		super(name);
		this.cb=cb;
	}
	
	public void run(){
		System.out.println("Begin Thread >>>>> "+Thread.currentThread().getName());
		try{
			System.out.println("Thread >>>>> "+Thread.currentThread().getName() +" sleeping for 5 seconds");
			Thread.currentThread().sleep(5000);
			System.out.println("cb.await(); >>>>> "+cb.await());
			
		}catch(Exception e){
			
		}
		System.out.println("End Thread >>>>> "+Thread.currentThread().getName());
	}
}

public class CyclicBarrierExample1{

	public static void main(String args[]){
	
		CyclicBarrier cb = new CyclicBarrier(3);
		
		System.out.println("cb.getParties() >>>>> "+cb.getParties());
		
		TestThreadOne t1= new TestThreadOne("t1",cb);
		t1.start();
		
		TestThreadOne t2= new TestThreadOne("t2",cb);
		t2.start();
		
		TestThreadTwo t3= new TestThreadTwo("t3",cb);
		t3.start();
	}
}