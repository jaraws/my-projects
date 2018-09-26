
import java.util.concurrent.*;
import java.util.Scanner;


class TestThreadForIsInterrupted extends Thread{
	
	TestThreadForIsInterrupted(){
	}
	public void run(){
			
			System.out.println("Thread >>>>>"+ Thread.currentThread().getId()+" /  isInterrupted: "+isInterrupted());

			try{
				Thread.currentThread().sleep(5000);
				/*
					From Oracle Documentation:
					=================================
					By convention, any method that exits by throwing an InterruptedException clears interrupt status when it does so. 
					However, it's always possible that interrupt status will immediately be set again, by another thread invoking interrupt.
				*/
			}catch(Exception e){
				interrupt();  //   <<<<<<<< This line of code will again set the interrupt status flag to true
				e.printStackTrace();
			}
			
			System.out.println("Thread >>>>>"+ Thread.currentThread().getId()+" /  isInterrupted: "+isInterrupted());

	}
}

class TestIsInterrupted{

	public static void main(String args[])throws Exception{

			TestThreadForIsInterrupted t1= new TestThreadForIsInterrupted();
		
			t1.start();
		
			Thread.currentThread().sleep(3000);

			// interrupt the thread t1
			t1.interrupt();		
	}
}