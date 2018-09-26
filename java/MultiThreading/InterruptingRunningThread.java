import java.util.concurrent.atomic.AtomicLong;

class TestThread extends Thread{
	
	static AtomicLong count;
	
	TestThread(String name){
		super(name);
		count = new AtomicLong(1);
	}
	public void run(){
	
		while(true){
		
			System.out.println("Thread: "+this.getName()+" / Count: "+(count.incrementAndGet()));
			if(count.longValue()<2000l){
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
				Sleep.sleep(5000);
				try{
						//this.interrupt();
				}catch(Exception e){
						System.out.println("Exception: "+e);
				}
	
			}
		}
	}
}
public class InterruptingRunningThread{

	public static void main(String args[]){
		
		Thread t1 = new TestThread("t1");
		t1.start();
		
		
		System.out.println("main thread exiting......");
	}
}