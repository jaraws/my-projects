/*
The interrupt mechanism is implemented using an internal flag known as the interrupt status. Invoking Thread.interrupt sets this flag. When a thread checks for an interrupt by invoking the static method Thread.interrupted, interrupt status is cleared. The non-static Thread.isInterrupted, which is used by one thread to query the interrupt status of another, does not change the interrupt status flag.
*/

class TestThreadOne extends Thread{
	public void run(){
			this.interrupt();
			System.out.println("If "+this.getName()+" thread interrupted: " +this.interrupted());
			System.out.println("If "+this.getName()+" thread interrupted: " +this.interrupted());
	}
}

class TestThreadTwo extends Thread{
	public void run(){
			
			System.out.println("If "+Thread.currentThread().getName()+" thread interrupted: " +Thread.currentThread().interrupted());
	}
}


public class TestInterrupt{
	public static void main(String args[]){
		
		TestThreadOne t1= new TestThreadOne();
		t1.start();
		TestThreadTwo t2= new TestThreadTwo();
		t2.start();
		t2.interrupt();
		
		t2.interrupted();
		t2.interrupted();
		t2.interrupted();

	}
}