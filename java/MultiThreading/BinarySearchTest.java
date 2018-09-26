

class BinarySearchTest{

	public static void main(String args[]){
	
		int[] array = {2,3,4,5,7,8};
		int element = Integer.valueOf(args[0]);
		
		System.out.println("Element: "+element);
		searchElement(array,element);
	}
	
	
	public static void searchElement(int[] array, int element){
	
		int start = 0;
		int end = array.length-1;
		
		while(start <= end){
			int mid = (start+end)/2;
			
			if(array[mid] == element){
				System.out.println("Element Found: "+element);
				return;
			}
			
			if(element < array[mid]){
				end= mid-1;
			}else{
				start = mid+1;
			}
		}
		System.out.println("Element NOT Found: "+element);
		
	}
}