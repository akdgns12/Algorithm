package Greedy;

import java.util.Scanner;

// �������
public class BOJ2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//����ؾ� �ϴ� ų�α׷� N
		int N = sc.nextInt();
		
		int count = 0;
		
		while(true) {
			if(N%5==0) {
				System.out.println(N/5 + count);
				break;
			} else if(N <=0) {
				System.out.println(-1);
				break;
			}
			N = N-3;
			count++;
		}
		
		
	}
}
