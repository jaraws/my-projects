
/*
		We are not allowed to create generic arrays because array carry type information of it’s
		elements at runtime. This information is used at runtime to throw ArrayStoreException if
		elements type doesn’t match to the defined type. Since generics type information gets
		erased at runtime by Type Erasure, the array store check would have been passed where it
		should have failed. Let’s understand this with a simple example code.
		List<Integer>[] intList = new List<Integer>[5]; // compile error
		Object[] objArray = intList;
		List<Double> doubleList = new ArrayList<Double>();

		doubleList.add(Double.valueOf(1.23));
		objArray[0] = doubleList; // this should fail but it would pass because
		at runtime intList and doubleList both are just List
		Arrays are covariant by nature i.e S[] is a subtype of T[] whenever S is a subtype of T but
		generics doesn’t support covariance or sub-typing as we saw in last question. So if we
		would have been allowed to create generic arrays, because of type erasure we would not
		get array store exception even though both types are not related.

*/
import java.util.*;
class TestArrayStoreException{
	
	public static void main(String... args) {
		Object[] s = new Integer[4];
		s[0] = 4.4;
		
		// The below statement would not work as Collections are not covarient by nature. However, arrays are covarient by nature.
		List<Long> list =  new ArrayList<Integer>();
	}
}