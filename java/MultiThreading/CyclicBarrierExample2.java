import java.util.concurrent.*;
import java.util.*;

/**
	CyclicBarrier : BrokenBarrierException example using reset()
	If a thread leaves a barrier point pre-maturely because of interruption or time out then all the threads waiting at the same
	barrier point will also leave abnormally via InterruptedException or BrokenBarrierException.
*/
class TestThreadOne extends Thread{
	
	CyclicBarrier cb;
	
	TestThreadOne(String name,CyclicBarrier cb){
		super(name);
		this.cb=cb;
	}
	
	public void run(){
		System.out.println("Begin Thread :  "+Thread.currentThread().getName());
		try{
			cb.await();
		}catch(Exception e){
			System.out.println("Exception: Thread :  "+Thread.currentThread().getName()+": "+e);
			
		}
		System.out.println("End Thread :  "+Thread.currentThread().getName());
	}
}

class TestThreadTwo extends Thread{
	
	CyclicBarrier cb;
	
	TestThreadTwo(String name,CyclicBarrier cb){
		super(name);
		this.cb=cb;
	}
	
	public void run(){
		System.out.println("Begin Thread :  "+Thread.currentThread().getName());
		try{
			System.out.println("Threads t1/t2 waiting at cyclic barrier for 3rd thread to arrive. Let "+Thread.currentThread().getName() +" call reset after 5 seconds.");
			System.out.println("Thread :  "+Thread.currentThread().getName() +" sleeping for 5 seconds");			
			Thread.currentThread().sleep(5000);
			cb.reset();
			
		}catch(Exception e){
			System.out.println("Thread :  "+Thread.currentThread().getName());
			e.printStackTrace();
		}
		System.out.println("End Thread :  "+Thread.currentThread().getName());
	}
}

public class CyclicBarrierExample2{

	public static void main(String args[]){
	
		CyclicBarrier cb = new CyclicBarrier(3);
		
		System.out.println("cb.getParties() :  "+cb.getParties());
		
		TestThreadOne t1= new TestThreadOne("t1",cb);
		t1.start();
		
		TestThreadOne t2= new TestThreadOne("t2",cb);
		t2.start();
		
		TestThreadTwo t3= new TestThreadTwo("t3",cb);
		t3.start();
	}
}