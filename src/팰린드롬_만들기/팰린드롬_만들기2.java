package 팰린드롬_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * input으로 주어진 이름의 순서를 적절히 바꿔서 팰린드롬으로 만들기
 * 
 */
public class 팰린드롬_만들기2 {
	public static String reverseString(String s	) {
		return (new StringBuffer(s)).reverse().toString();
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int[] a =  new int[26];
		for(int i=0; i<s.length(); i++	) {
			a[s.charAt(i) - 'A']++;
		}
		int midIdx = 0, odd= 0;
		for(int i=0; i<a.length; i++) {
			if(a[i]%2 !=0) {
				midIdx = i;
				odd++;
			}
		}
		
		if((s.length()%2 !=0 && odd>1) || (s.length()%2 ==0 && odd>0)) {
			System.out.println("I'm Sorry Hansoo");
		}else {
			String ans =  " ";
			for(int i=0; i<a.length; i++) {
				for(int j=0; j<a[i]/2; j++) {
					ans += ((char)(i+'A'));
				}
			}
			String rev = reverseString(ans);
			if(odd==1) ans += ((char)(midIdx+'A'));
			System.out.println(ans+rev);
		}
		
		
	}
}
