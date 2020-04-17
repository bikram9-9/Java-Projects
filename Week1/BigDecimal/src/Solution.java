import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Solution {
public static void main(String[] args) throws Exception{
	Scanner sc = new Scanner(System.in);
	int num_values = sc.nextInt();
	 if(num_values < 1 || num_values > 20) {
		 throw new IllegalArgumentException();
	 }
	 
	 List<BigDecimal> list = new ArrayList<BigDecimal>();
	
	for(int i =0;i<num_values;i++) {
		list.add(new BigDecimal(sc.next()));
	}
	Collections.sort(list, Collections.reverseOrder());
	

	System.out.print(list);
}

}
