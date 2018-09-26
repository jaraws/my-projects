class Budgies{
	String name;
	
	Budgies(String name){
		this.name = name;
	}
	
	void updateName(String newName){
		this.name = newName;
	}
	
	public String toString(){
		return "Budgie: "+name;
	}
}
class TestFinal{
	private static final Budgies bObj = new Budgies("Fredo");
	
	public static void main(String ...a){
	
		System.out.println(bObj);
		/*
		 Its the reference variable which is final; not the target object. final ensures that a variable can be assigned a value only once.
		 However, the state of the target object can change as shown here. The Budgies name got updated from Fredo to Alfanso without
		 any error.
		*/
		// bObj = null;
		Budgies newObj = bObj;
		newObj.updateName("Alfanso");
		
		System.out.println(bObj);
	}
}