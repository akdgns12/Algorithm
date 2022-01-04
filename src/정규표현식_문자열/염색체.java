package 정규표현식_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 염색체 {
	// BOJ 9342 / 염색체 / 정규표현식 / 실 2
	static int T;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		/*
		 * [] : 문자의 집합, 범위를 나타냄. 두 문자 사이는 -기호로 범위를 나타냄
		 * []내에 ^가 선행하여 존재하면 not을 나타냄
		 */
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		// 조건 1
		//  ^ : 문자열의 시작
		//  [A-F]? : a부터 ~ F까지의 문자 없거나 하나있음
		// 조건 2,3,4 
		// A+ : A가 하나 이상
		// F+ : F가 하나 이상
		// C+ : C가 하나 이상
		// 조건 5
		// [A-F]? : A부터 F까지의 문자 없거나 하나있음
		// $ : 문자열 종료
		for(int i=0; i<T; i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
		}
	}
}
