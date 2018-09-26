interface MyInterface{

	public static final int a =10;
}

class One implements MyInterface{
	
	public static void print(){
		System.out.println("One.."+One.a);
	}
	
}

class Two implements MyInterface{
	
	public static void print(){
		System.out.println("Two.."+Two.a);
	}
	
}

public class InterfaceDemoOne{

	public static void main(String args[]){
		One o1 =new One();
		o1.print();
		
		Two o2 =new Two();
		o2.print();
	
	}

}