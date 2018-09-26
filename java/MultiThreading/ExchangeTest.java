
import java.util.concurrent.*;

class TestThread extends Thread{

	Exchanger exchangerObj;
	String objectToExchange;
	
	TestThread(Exchanger exchangerObj,String objectToExchange){
			this.exchangerObj= exchangerObj;
			this.objectToExchange = objectToExchange;
	}
	public void run(){
		
		try{
			System.out.println("Thread:"+ Thread.currentThread().getId()+" was having object: "+objectToExchange);
			Object obj = exchangerObj.exchange(this.objectToExchange);	
			System.out.println("Thread:"+ Thread.currentThread().getId()+" now have: "+objectToExchange);
		}catch(Exception e){
			
		}
		
	}
}
class ExcehangeTest{

	public static void main(String args[]) throws Exception{
		
		Exchanger exchangerObj = new Exchanger();
		
		TestThread t1= new TestThread(exchangerObj,"t1");
		TestThread t2= new TestThread(exchangerObj,"t2");
		
		t1.start();
		
		Thread.currentThread().sleep(5000);

		t2.start();
		
	}
}