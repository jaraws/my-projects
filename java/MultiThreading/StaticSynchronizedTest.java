class Boy {
	
	synchronized public static void show(){
		System.out.println("entering show..");
		try{
			System.out.println(Thread.currentThread().getName()+ "- acquired lock over object b1");
			Thread.currentThread().sleep(10000);
		}catch(Exception e){
		
		}finally{
			System.out.println("exiting show..");
		}
	}
	
	synchronized  public static void print(){
		System.out.println("print..");
	}
	
	synchronized  public  void display(){
		System.out.println("display..");
	}
}

class Boy1 implements Runnable{
	
	Boy b;
	
	Boy1(Boy b){
		this.b=b;
	}
	
	public void run(){
		b.show();
	}
}

class Boy2 implements Runnable{
	Boy b;
	
	Boy2(Boy b){
		this.b=b;
	}
	
	public void run(){
		b.print();
	}
}

class Boy3 implements Runnable{
	Boy b;
	
	Boy3(Boy b){
		this.b=b;
	}
	
	public void run(){
		b.display();
	}
}

class StaticSynchronizedTest{

	public static void main(String args[]){
		
		Boy b = new Boy();
		
		Boy1 b1 =new Boy1(b);
		Thread t1= new Thread(b1);
		t1.start();
		
		Boy2 b2 =new Boy2(b);
		Thread t2= new Thread(b2);
		t2.start();
		
		Boy3 b3 =new Boy3(b);
		Thread t3= new Thread(b3);
		t3.start();
		
		System.out.println("main thread exiting.....");
	}
}