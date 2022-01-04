package Algorithm;

import java.io.IOException;
import java.util.Scanner;

// 폴리오미노
// 문자열 처리 문제
// X의 개수가 홀수이면 -1출력
// 그리디 알고리즘.. 이중 반복문도 이런식이면 참 어렵다
public class BOJ_1343 {
	static String result = "";
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		// 한글자 X만 입력되었을 때
		if(s.equals("X")) {
			System.out.println(-1);
			return;
		}
		
		char c;
		int count=0;
		
		for(int i=0; i<s.length(); i++) {
			c = s.charAt(i);
			if(c=='X') {
				count++;
				if(i==s.length()-1) {
					if(count%2==1) {
						System.out.println(-1);
						return;
					} else {
						print(count);
					}
				}
			}else if( c== '.') {
				if(count%2==1) {
					System.out.println(-1);
					return;
				}else {
					print(count);
					result +=".";
					count = 0;
				}
			}
		}
		System.out.println(result);
		
		
	}
	// size 인자 = 문자열에서 . 로 구분된 각각의 X의 개수
	static void print(int size) {
		while(size>0) {
			if(size>=4) {
				result += "AAAA";
				size -=4;
			}else {
				result += "BB";
				size -=2;
			}
		}
	}
}
