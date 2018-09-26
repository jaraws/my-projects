/**
	C U S T O M -- T H R E A D -- P O O L
	
	1. First you should have a task to submit to thread pool i.e. Task
	2. Next you should have a thread pool i.e. ThreadPool >>> HOLDS(Thread+Task)
	3. Next you should have threads inside the pool i.e. WorkerThread
*/

import java.util.*;

/**
	Task: executed by WorkerThread of the ThreadPool
*/
class Task extends Thread{
	
	String name;
	
	Task(int name){
		this.name="Task-"+name;
	}
	public void run(){
		System.out.println(this.name+ " >> executed by Thread >>"+ Thread.currentThread().getName());
	}
}

/**
	WorkerThread:  WorkerThread s together forms the ThreadPool, which actually executes the Task
*/
class WorkerThread extends Thread{

	List<Task> taskList;
		
	WorkerThread(int workerThreadName,List<Task> taskList){
		super(""+workerThreadName);	
		this.taskList = taskList;
	}
	public void run(){
		
		while(true){
			try{
				synchronized(taskList){
					
					if(taskList.size()>0){
						Task task = taskList.remove(0);
						task.run();
						// To let other WorkerThreads execute the other Task
						taskList.notify();
					}else{
						// causes the current WorkerThread to move into wait set of taskList object
						taskList.wait(1000);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	}
}

class WorkerThreadPool{
	
	List<Task> taskList;
	
	WorkerThreadPool(int poolSize){
		
			taskList =  new ArrayList<Task>();	
			for(int i = 0 ; i<poolSize; i++){
				// taskList has to be shared with each WorkerThread, as from here only Task will be picked by WorkerThread s
				WorkerThread workerThread = new WorkerThread(i,taskList);
				workerThread.start();
			}
	}
	
	/*
		Method used to submit the task to the thread pool
	*/
	void submit(Task task){
		synchronized(taskList){
			taskList.add(task);
			taskList.notify();
		}
	}
}


public class CustomThreadPool{
	
	public static void main(String args[]){
		
		// Creating WorkerThreadPool
		WorkerThreadPool workerThreadPool = new WorkerThreadPool(5);
		
		// Submit tasks to WorkerThreadPool
		for(int i=0;i<10;i++){
			
			workerThreadPool.submit(new Task(i));
			
			try{
				Thread.currentThread().sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("main(String args[]) exiting ....");
	}
}