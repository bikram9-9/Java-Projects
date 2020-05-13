import java.util.ArrayList;

public class Main {

			public static void main(String[] args) {
				
				ArrayList<Student> list = new ArrayList<Student>();
				list.add(new Student("Bikram", 123));
				list.add(new Student("Taran", 333));
				
				
				
				System.out.println((list.get(0).equals(list.get(1))? "Equals": "Not Equals"));
			}

}
