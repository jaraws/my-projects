class TestThread extends Thread{
		
		TestThread(String str){
			super(str);
			System.out.println(Thread.currentThread().getName()+" >> A");
		}
		public void run(){
			System.out.println(Thread.currentThread().getName()+" >> B");
		}

}

class AnonymousTest{

	public static void main(String args[]){
		
			/*
				Anonymous Inner Class
				------------------------------
				1. Below is an example of Anonymous Inner class.
				2. Such classes does not have any name.
				3. They either implement an interface or extend a class, as here the below anonymous class is extending TestThread class.
				4. Such classes are defined and instantiated in a single statement.
				5. Since anonymous class does not have any name; and for the same reason we can not define the constructor for them.
			*/
			Thread t1 = new TestThread("t1"){ // ------ Anonymous class begins here extending class TestThread ------
				public void run(){
					System.out.println(Thread.currentThread().getName()+" >> C");
				}
				// ----- Anonymous class ends here extending class TestThread -----
			};
			t1.start(); // 1. Calls the super class constructor 2. Then executes its overridden run() method
			
			Thread t2 =  new TestThread("t2");
			t2.start();
	}
}