import java.util.Scanner;
public class test {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int input = sc.nextInt();
	sc.close();
	System.out.print(isPrime(input));
	
}


private static boolean isPrime(int n) {
	double sqrt = Math.sqrt(n);
	for(int i=2;i<=sqrt;i++) {
		if(n % i == 0) {
			return false;
		}
	}
	return true;
}
}
