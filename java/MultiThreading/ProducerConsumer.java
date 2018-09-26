/*
	Producer Consumer Problem:
	
	1. Prepare a Resource which will be shared between Producer and Consumer
		>> value: which will be produced and consumed
		>> flag:  which will be a means as a communication between Producer and Consumer threads
	2. Prepare a Producer
	3. Prepare a Consumer
	4. Prepare a main() program to start the program
	
	Producer-----> || R E S O U R C E [value, flag] || <------ Consumer
	
	@author: Swaraj 
*/

/**
	This class will be shared in between Producer and Consumer
	Threads.
*/
class Resource{
	
		int value;
		boolean flag;
		// flag : false indicates that producer has not produced a new value
		// flag: true indicates that producer has produced a new value

		public void incrementValue(){
			value = value+1;
		}
		
		public int getValue(){
			return value;
		}
		
		public void setFlag(boolean flag){
			this.flag = flag;
		}
		
		public boolean getFlag(){
			return flag;
		}

}
class Producer extends Thread{
	
	Resource resource;
	
	Producer(Resource resource){
		this.resource = resource;
	}
	public void run(){
		
		while(true){
			try{
				// Get lock over shared resource
				synchronized(resource){
					
					if(resource.getFlag() == false){
						resource.incrementValue();
						System.out.println("Producer thread producing value >> "+resource.getValue());
						resource.setFlag(true);
						// notify all the threads waiting in wait set of resource object to get hold of resource object
						resource.notify();	
					}else{
						// If the values is not consumed yet; then let this thread move into wait set of resource object
						resource.wait();
					}	
				}
				Thread.currentThread().sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread{
	
	Resource resource;
	
	public Consumer(Resource resource){
		this.resource = resource;
	}
	public void run(){
		
		while(true){
			try{
				// Get lock of shared resource
				synchronized(resource){
					if(resource.getFlag() == true){
						System.out.println("Consumer thread consuming value >> "+resource.getValue());
						System.out.println("--------");
						resource.setFlag(false);
						// notify all the threads waiting in wait set of resource object to get hold of resource object
						resource.notify();
					}else{
						// If the values is not produced yet; then let this thread move into wait set of resource object
						resource.wait();
					}
				}
			
				Thread.currentThread().sleep(2000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}	
}
public class ProducerConsumer{
	
	public static void main(String args[]){
	
		Resource resource = new Resource();
		Producer producer = new Producer(resource);
		Consumer consumer = new Consumer(resource);
		
		producer.start();
		consumer.start();
		
	}
}