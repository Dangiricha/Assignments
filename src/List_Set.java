import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Method with List and Set as return type
 */

public class List_Set {
	
	
	public static List<String> list(){
		List<String>  ls = new ArrayList<String>();
	ls.add("Rohan");
	ls.add("Riya");
	ls.add("Ram");
	ls.add("Ramesh");
	System.out.println("The size of Name list is: "+ ls.size());
	return ls;
		
	}
	
	public static Set<String> set(){
		Set<String>  set = new HashSet<String>();
		 set.add("Tom");
		 set.add("Tammy");
		 set.add("Jack");
		 set.add("John");
		 set.add("Jennifer");
		 set.add("Kaya");
		 set.add("Ryan");
		 set.add("Lysa");
		 System.out.println("The size of Name set is: "+ set.size());
		 return set;
	}

}
