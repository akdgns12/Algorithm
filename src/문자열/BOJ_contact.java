package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//(100+ 1+ | 01)+
//정규표현식을 알고있는지에 관한 문제
//프로그래머스 "불량사용자"와 비슷한 문제

/*
 * 이 문제에서 사용된 정규표현식
 * str.matches(regex)함수 : str이 정규표현식인 regex와 일치하는지 확인
 * () : 괄호 안의 문자를 하나의 문자로 인식
 *  | : 패턴 안에서 or 연산 수행
 *  + : 바로 앞 문자가 하나 이상
 */
public class BOJ_contact {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String vega = "(100+1+|01)+";
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			if(str.matches(vega))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}

}
