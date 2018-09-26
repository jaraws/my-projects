

/*
	Pass-by-value:
	The actual parameter is fully evaluated and the resulting value is copied to a SEPARATE LOCATION() being used to hold the formal parameter's value during method execution. That separate location is typically a chunk of memory on the runtime stack for the method called Method Runtime Stack. 
	Eg: C/Java 
	
	Pass-by-reference:
	The formal parameter merely acts as an alias for the actual parameter. Any time the method/function uses the formal parameter (for reading or writing), it is actually using the actual parameter.
	Eg: C++/Ada/Pascal
*/

class Animal{
	
	String animalType;
	
	Animal(String animalType){
		this.animalType=animalType;
	}
	
	public void setAnimalType(String animalType){
		this.animalType=animalType;
	}
	
	public String getAnimalType(){
		return animalType;
	}
}

class JavaPassByValueStrictly{

	// t1 receives: 1000 and t2 receives: 2000
	static void swap(Animal t1, Animal t2)// t1 and t2 are formal parameters here
	{
		Object temp;
		
		// here t1 and t2 both are separate variables then a1 and a2. And both are pointing to object referenced by a1 and a2.
		t1.setAnimalType("rabbit");
		t2.setAnimalType("parrot");
		
		/*
		 * Now in the swap logic below; It's NOT the objects memory location which interchange, but its the value of t1 and t2 
		 * which gets exchange i.e. 1000 and 2000.
		 */
		temp =t1;
		t1=t2;
		t2=(Animal)temp;
	
	}
	public static void main(String args[]){
		
		Animal a1=new Animal("dog"); // address: 1000
		Animal a2=new Animal("cow"); // address: 2000
		
		System.out.println("a1: "+a1+" / a2: "+a2); // a1 holds the value: 1000 / a2 holds the value: 2000
		System.out.println("a1: "+a1.getAnimalType()+" / a2: "+a2.getAnimalType());

		/* 
			Here, only the value stored in variable is being shared, which is 
			memory address of objects Animal("dog") and Animal("cow") i.e. 1000 and 2000
		*/
		swap(a1,a2); // a1,a2 are actual parameters here

		System.out.println("a1: "+a1+" / a2: "+a2);
		System.out.println("a1: "+a1.getAnimalType()+" / a2: "+a2.getAnimalType());
	}
}