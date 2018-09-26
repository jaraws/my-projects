
/*
		Well this is a strange situation. We all have seen NullPointerException when we
	invoke a method on object that is NULL. The compiler will give warning as “The static
	method sayHello() from the type Test should be accessed in a static way” but when executing it
	will work and prints “Hello...”.
	
	Ideally Java API should have given error when a static method is called from an object
	rather than giving warning, but I think it’s too late now to impose this. And most strange
	of all is that even though obj is null here, when invoking static method it works fine. 
	
	I think	it’s working fine because Java runtime figures out that sayHello() is a static method and calls it
	on the class loaded into the memory and doesn’t use the object at all, so no NullPointerException

*/
class StaticMethodInvocationTest{

	static String sayHello(){
		return "Hello...";
	}
	
	
	public static void main(String args[]){
		
		StaticMethodInvocationTest obj = null;
		
		System.out.println(obj.sayHello());
	}
}