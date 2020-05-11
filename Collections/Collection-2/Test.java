import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
public class Test {
	public static void main(String[] args) {
		
	//Map Implementation
	HashMap<Integer,String> hm = new HashMap<Integer,String>();
	hm.put(1,"Bikram");
	hm.put(2,"Gurisha");
	hm.remove(2);
	System.out.println(hm);
	
	//Set Implementation
	HashSet<Integer> hs = new HashSet<Integer>();
	hs.add(5);
	hs.add(10);
	hs.remove(10);		//object based
	System.out.println(hs);
	
	//List implementation
	List<Integer> list = new LinkedList<Integer>();
	list.add(5);
	list.add(10);
	list.remove(1);		//index based
	System.out.println(list);
	}
	
}
