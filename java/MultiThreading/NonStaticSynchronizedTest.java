class Boy implements Runnable{
	
	synchronized public void show(){
		System.out.println("entering show..");
		try{
			System.out.println(Thread.currentThread().getName()+ "- acquired lock over object b1");
			Thread.currentThread().sleep(10000);
		}catch(Exception e){
		
		}finally{
			System.out.println("exiting show..");
		}
	}
	
	synchronized public void print(){
		System.out.println("print..");
	}
	
	public void run(){
		show();
	}
}


class NonStaticSynchronizedTest{

	public static void main(String args[]){
		
		Boy b1 =new Boy();
		Thread t1= new Thread(b1);
		t1.start();
		
		Thread t2= new Thread(b1);
		t2.start();
		
		System.out.println("main thread exiting.....");
	}
}