import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);

		//foreach
		list.forEach(number ->{
			System.out.println(number + 3);
		});
		
		System.out.println("--------------------------");
		//streams to print out only even numbers
		list.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
		
		
		System.out.println("--------------------------");
		//functional methods
		list.stream().filter(x -> x ==4).forEach(System.out::println);

	}
	


}
