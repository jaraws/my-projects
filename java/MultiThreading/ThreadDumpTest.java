

class ThreadDumpThread extends Thread{
	
	ThreadDumpThread(String threadName){
		super(threadName);
	}
	
	public void run(){
		
		String lockingObject = "monitor";
		
		synchronized(lockingObject){	
				try{
					System.out.println("Sleeping for 10 seconds: "+Thread.currentThread().getName());
					Thread.currentThread().sleep(10000);
					System.out.println("Awaking after 10 seconds: "+Thread.currentThread().getName());
				}catch(Exception e){
					
				}
				lockingObject.notifyAll();
		}
	}
}
class ThreadDumpTest{
	
	public static void main(String args[])throws Exception{
	
		int id=1;
		do{
				Thread t = new ThreadDumpThread(""+id);
				t.start();
				Thread.currentThread().sleep(5000);
				id++;
		}while(true);
	}
}