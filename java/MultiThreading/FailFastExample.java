import java.util.*;

public class FailFastExample
{
    
    
    public static void main(String[] args)
    {
        Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            //premiumPhone.put("XYZ", "Xperia Z"); // The ConcurrentModification exception is thrown only when there is a change in underlying data structure of the HashMap
			premiumPhone.put("HTC", "Xperia Z"); // However, there is no exception if there is a change only in the data of the underlying data structure
        }
        
    }
    
}