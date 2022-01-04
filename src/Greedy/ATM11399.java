package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int prev = 0; // ���������� ���ð� ����
		int sum = 0; //���ð� ����
		
		for(int i=0;i<n;i++) {
			// ���������� ���ð��� �������� �ɸ��� �ð��� �����ش�
			sum +=prev + arr[i];
			// ���������� �����տ� ���� �ɸ��� �ð��� �����ش�.
			prev += arr[i];
		}
		System.out.println(sum);
	}
}
