class One{

	public void say(){
		System.out.println("One..");
	}
	
	public void speak(){
			System.out.println("First..");
	}
}

class Two extends One{
	
	public void say(){
		System.out.println("Two..");
	}
	
	public void speak(){
			System.out.println("Second..");
	}
}

public class OverridingDemoOne{

	public static void main(String args[]){
		One o =new Two();
		
		o.say();
	
	}

}