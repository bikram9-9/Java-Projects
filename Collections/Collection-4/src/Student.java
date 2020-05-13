
public class Student {
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
	
	//OVerride hashcode and  equals method
	
	//checks if they are the same object (not object values)
	
	 @Override
	    public boolean equals(Object o) { 
		 
		 //null check 
		 if(o == null) return false;
		 //equals check
		 if(this == o) return true;
		 
		 if(o instanceof Student && ((Student) o).toString() == this.toString()) {
			 return true;}
			 else return false;
		 }

	 
	 @Override
	 public int hashCode() {
		 int result = 0;
			result = (int) (roll / 11);
			return result;
	 }

	 } 
	 


