/*
All methods that are accessible are inherited by subclasses.

From the Sun Java Tutorials:

A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. You can use the inherited members as is, replace them, hide them, or supplement them with new members
The only difference with inherited static (class) methods and inherited non-static (instance) methods is that when you write a new static method with the same signature, the old static method is just hidden, not overridden.

From the page on the difference between overriding and hiding.

The distinction between hiding and overriding has important implications. The version of the overridden method that gets invoked is the one in the subclass. The version of the hidden method that gets invoked depends on whether it is invoked from the superclass or the subclass
*/

class MyStaticDemo{

	public static int a =10;
}

class One extends MyStaticDemo{
	
	public static int a =11;
	
	public static void print(){
	
		System.out.println("MyStaticDemo.."+MyStaticDemo.a);
		System.out.println("One.."+One.a);
	}
	
}

public class MyStaticDemoOne{

	public static void main(String args[]){
		One o1 =new One();
		o1.print();
	}

}