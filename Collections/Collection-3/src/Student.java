
public class Student implements Comparable<Student> {
	int roll;
	String name;
	public Student(String name, int roll) {
		this.roll = roll;
		this.name = name;
	}
	
	public String toString() 
    { 
        return this.roll + " " + this.name;
                          
    }

	@Override
	public int compareTo(Student a1) {		
		return this.name.compareTo(a1.name);
	} 
}
