package 매일코딩;

import java.util.Scanner;

public class 팰린드롬만들기_BOJ1213 {
	// BOJ 팰린드롬_만들기 실4 / 아이디어 
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		String str = sc.next();
		int[] a = new int[26];
		for(int i=0; i<str.length(); i++) {
			a[str.charAt(i) - 'A']++;
		}
		// 길이가 짝수면 모든 알파벳의 개수도 짝수여야 함
		// 길이가 홀수면 하나의 알파벳 개수만 홀수여야 함
		int oddCnt = 0, oddIdx = 0;
		
		for(int j=0; j<a.length; j++) {
			if(a[j] % 2 == 1) {
				oddCnt++;
				oddIdx = j;
			}
		}
		
		
		if((str.length() % 2 == 0 && oddCnt > 0) | (str.length() % 2 == 1 && oddCnt != 1)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		
		
	}
}
