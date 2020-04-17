
/*
 * instanceof checks whether an given object is instance of a class
 */
public class child extends parent{
public static void main(String[] args) {
	
	parent dad = new parent();
	
	System.out.print((dad instanceof parent)?"its an instance":"its not"); 
}
}
