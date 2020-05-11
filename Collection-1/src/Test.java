import java.util.Arrays;
public class Test {

	public static void main(String[] args) {
	
	String s = null;
	int year = 0;
	Game game = new Game(s, year);
	Object[] arr =  { "taran", 23, 14.2, false,game};
	
	System.out.print(Arrays.toString(arr));
	}

}
