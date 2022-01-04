package 정규표현식_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1013 {
	// Contact / 골드 5 / 정규표현식
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		/*
		 * () : 소괄호 안의 문자를 하나의 문자로 인식
		 *  | : 패턴 안에서 or 연산을 수행할 때 사용
		 */
		String regex = "(100+1+|01)+";
		
		for(int i=0; i<T; i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
