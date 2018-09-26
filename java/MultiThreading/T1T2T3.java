package jaraws.jpa.JPADemo;

/**
 Write a program that T2 should finish after T1 and T3 should finish after T2

*/
class Runner extends Thread{
	
	private static int highestPriority = 1;
	private int priority;
	private boolean executed;
	
	public Runner(int priority) {
		super();
		this.priority = priority;
	}

	public void run() {
		
			synchronized(Runner.class) {
				//System.out.println("Locking thread has priority: "+ priority);
				while(!executed) {
					if(this.priority != highestPriority) {
						try {
							//System.out.println("Thread going in wait state has priority >>>>>> "+ priority);
							Runner.class.wait();
							//System.out.println("Thread coming out of wait state has priority <<<<<< "+ priority);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}else {
						System.out.println("Executed thread with priority: "+ priority);
						executed = true;
						highestPriority++;
						Runner.class.notify();
					}
				}
			}		
	}
}

public class T1T2T3 {

	private static Object lock = new Object();
	
	public static void main(String args[]) throws InterruptedException {
		
		Runner t1 = new Runner(1);
		Runner t2 = new Runner(2);
		Runner t3 = new Runner(3);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
