package 문자열;

import java.io.IOException;
import java.util.Scanner;

public class 팰린드롬_만들기 {
	// BOJ 1254 팰린드롬 만들기 실 1 / 문자열
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		System.out.println(solve(str));
	}
	
	public static int solve(String str) {
		int len = str.length();
		
		for(int i=0; i<len; i++) {
			if(isPalindrome(str.substring(i))) {
				return len + i;
			}
		}
		return 0;
	}
	
	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;
		
		while(start <= end) {
			if(str.charAt(start) != str.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
