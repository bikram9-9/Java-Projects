import java.util.Comparator;

public class SortByRoll implements Comparator<Student> {
	
	@Override
	public int compare(Student a1, Student a2) {
		return a1.roll - a2.roll;
	}
	
	
}
