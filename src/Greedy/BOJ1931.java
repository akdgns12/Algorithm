package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// ȸ�ǽ� ����

/*
 * N���� ȸ��, �� ȸ�� i�� ���� ���۽ð�, ����ð� �־���.
 * ���� ��ġ�� �ʴ� Ȱ���� ���� ����ð��� ������ �� ���� Ȱ���� �� �� �ִ�.
 * ���� �ð� �������� ���� *����ð��� ���� ��찡 �ֱ� ������ �̷� ��쿡�� ���۽����� �������� ������������ ����������Ѵ�.
 */
public class BOJ1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i = 0; i<n; i++) {
			arr[i][0]=sc.nextInt();	
			arr[i][1]=sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[] start, int[] end) {
				if(start[1]==end[1]) {
					//����ð��� ������쿣 ���۽ð����� ����
					return Integer.compare(start[0],end[0]);
				}
				return Integer.compare(start[1],end[1]);
			}
		});
		
		int count = 0;
		int end = -1;
		for(int i=0; i<n; i++) {
			if(arr[i][0]>=end) {
				end=arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}
}