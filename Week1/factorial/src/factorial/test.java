package factorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		System.out.print(factorial(input));

	}
	
	private static List<Integer> factorial(int n) {
		List<Integer> list = new ArrayList<>(); 
		int prev2= 1;
		list.add(prev2);
		int prev=2;
		list.add(prev);
		int curr = prev+prev2;
		int temp =0;
		
	
		while(curr < n) {
			curr = prev +prev2; 
			prev2=prev; 
			prev=curr;
			if(curr <n) {
				list.add(curr);
			}
			
		}
		
		return list;
	}

}
