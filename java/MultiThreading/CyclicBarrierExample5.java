import java.util.concurrent.*;
import java.util.*;

/**
	CyclicBarrier : BrokenBarrierException example using reset()
	If a thread leaves a barrier point pre-maturely because of interruption or time out then all the threads waiting at the same
	barrier point will also leave abnormally via InterruptedException or BrokenBarrierException.
	
	Note: Calling await() over a broken barrier will always result in BrokenBarrierException; therefore, reset the barrier before
	using it again.
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
		System.out.println("If CyclicBarrier broken :  "+cb.isBroken());
		
		synchronized(this.getClass()){
			if(cb.isBroken()){
				System.out.println("Thread :  "+Thread.currentThread().getName()+": Resting cyclic barrier..");
				cb.reset();
			}else{
				System.out.println("Thread :  "+Thread.currentThread().getName()+": cyclic barrier already reset");
			}
		}
		
		try{
			cb.await();
		}catch(Exception e){
			System.out.println("Exception: Thread :  "+Thread.currentThread().getName()+": "+e);	
		}
		
	}
}

class TestThreadTwo extends Thread{
	
	CyclicBarrier cb;
	Thread t;
	
	TestThreadTwo(String name,CyclicBarrier cb, Thread t){
		super(name);
		this.cb=cb;
		this.t=t;
	}
	
	public void run(){
		System.out.println("Begin Thread :  "+Thread.currentThread().getName());
		try{
			System.out.println("Threads t1/t2 waiting at cyclic barrier for 3rd thread to arrive. Let "+Thread.currentThread().getName() +" interrupt thread t1.");
			System.out.println("Thread :  "+Thread.currentThread().getName() +" sleeping for 5 seconds");			
			Thread.currentThread().sleep(5000);
			t.interrupt();
			
		}catch(Exception e){
			System.out.println("Thread :  "+Thread.currentThread().getName());
			e.printStackTrace();
		}
		System.out.println("End Thread :  "+Thread.currentThread().getName());
	}
}

class CyclicBarrierMonitor implements Runnable{
	CyclicBarrier cb;
	CyclicBarrierMonitor(CyclicBarrier cb){
		this.cb=cb;
	}
	public void run(){
		while(true){
			try{
				System.out.println("Monitor: Awaiting threads at CyclicBarrier: "+cb.getNumberWaiting());
				Thread.currentThread().sleep(5000);
			}catch(Exception e){
				
			}
			
		}
	}
}
public class CyclicBarrierExample5{

	public static void main(String args[]){
	
		CyclicBarrier cb = new CyclicBarrier(3);
		
		System.out.println("cb.getParties() :  "+cb.getParties());
		
		TestThreadOne t1= new TestThreadOne("t1",cb);
		t1.start();
		
		TestThreadOne t2= new TestThreadOne("t2",cb);
		t2.start();
		
		TestThreadTwo t3= new TestThreadTwo("t3",cb,t1);
		t3.start();
		
		CyclicBarrierMonitor cbm = new CyclicBarrierMonitor(cb);
		(new Thread(cbm)).start();
	}
}