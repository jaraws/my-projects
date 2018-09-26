class One{

	public static void say(){
		System.out.println("One..");
	}
	
	public void speak(){
			System.out.println("First..");
	}
}

class Two extends One{
	
	public static void say(){
		System.out.println("Two..");
	}
	
	public void speak(){
			System.out.println("Second..");
	}
}

public class OverridingDemoTwo{

	public static void main(String args[]){
		One o =new Two();
		
		o.say();
	
	}

}