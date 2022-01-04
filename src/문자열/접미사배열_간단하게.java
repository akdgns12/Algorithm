package 문자열;

import java.util.Arrays;
import java.util.Scanner;

public class 접미사배열_간단하게 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = s.length();
		String[] a = new String[n];
		
		for(int i=0; i<n; i++) {
			a[i] = s.substring(i); // i번째부터 끝까지 주르륵 자른다
		}
		
		Arrays.sort(a);
		for(int i=0; i<n; i++) {
			System.out.println(a[i]);
		}
		
	}
}
