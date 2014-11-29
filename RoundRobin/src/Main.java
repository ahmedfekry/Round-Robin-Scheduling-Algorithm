import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input the number of process ");
		int n = in.nextInt();
		int[] brt = new int[n];
		System.out.println("Enter Burst Times : ");
		for(int i=0; i < n ; ++i) {
			int x = in.nextInt();
			brt[i] = x;
		}
		
		System.out.println("Enter Quantum Time : ");
		int q = in.nextInt();
		RoundRobin RR = new RoundRobin(brt,q,n);
		RR.process();
		
	}
}
