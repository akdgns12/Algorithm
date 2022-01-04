package Algorithm;

import java.util.Scanner;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,k;
		
		n = sc.nextInt();
		k = sc.nextInt();
		int count=0;
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=n-1; i>=0; i--) {
			if(k>=arr[i]) {
				count+=k/arr[i];
				k= k%arr[i];
			}
		}
		System.out.println(count);
		
	}

}
