
/**
	Java compiler always puts up a call to default constructor of super class 
	though this behaviour could be altered by using the super() keyword as
	first statement of the constructor.
*/
class Hello{

	Hello(){
		System.out.println("default");
	}	
	Hello(String abc){
		System.out.println("parametrized");
	}	
	
}

public class SuperClassConstructor extends Hello{

	SuperClassConstructor(){

	}

	public static void main(String args[]){
		SuperClassConstructor t = new SuperClassConstructor();
	}
}