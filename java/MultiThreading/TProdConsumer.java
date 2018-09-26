
class TProducer extends Thread{

	Mutator mutator;
	
	TProducer(Mutator mutator){
		this.mutator = mutator;
	}
	public void run(){
		
		while(true){
			try{
					synchronized(mutator){
					
						if(!mutator.consumed){
							wait();
						}
						// produce a value
						mutator.value++;
						System.out.println("Produced value: "+mutator.value);
						mutator.consumed = false;
						Thread.currentThread().sleep(1000);
						notify();
					}
					
			}catch(Exception e){
				
			}
		}
	}
}

class TConsumer extends Thread{
	
	Mutator mutator;
	
	TConsumer(Mutator mutator){
		this.mutator = mutator;
	}
	
	public void run(){
		
		while(true){
			try{
					synchronized(mutator){					
						if(mutator.consumed){
							wait();
						}
						// consume a value
						System.out.println("Consumed value: "+mutator.value);
						mutator.consumed=true;
						Thread.currentThread().sleep(1000);
						notify();
					}			
			}catch(Exception e){
				
			}
		}
	}

}

class Mutator{
	
	boolean consumed = true; // If the produced data is concumed or not
	int value =0;
	
}
class TProdConsumer{
	
	public static void main(String args[]){
	
		Mutator mutator = new Mutator();
		TProducer t1 = new TProducer(mutator);
		t1.setName("producer");
		TConsumer t2 = new TConsumer(mutator);
		t2.setName("consumer");
		
		t1.start();
		t2.start();
	}
}