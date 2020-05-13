import java.util.ArrayList;
import java.util.Collections;

//We are sorting by role using Comparator and Sorting by Name using Comparable
public class Test  {
	public static void main(String[] args) {

		//
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("Aikram", 256));
		list.add(new Student("Singh", 898));
		list.add(new Student("Aaran", 145));
		
		//Print sorted order by Roll
//		Collections.sort(list, new SortByRoll());
		
		Collections.sort(list);
		
		list.forEach(student ->{
			System.out.println(student);
		});

	}
	
	
	
	
	

	


}