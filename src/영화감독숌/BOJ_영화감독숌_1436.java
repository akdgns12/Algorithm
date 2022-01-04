package 영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1. 브루트 포스로 무작정 푸는 방법이 있고 = 내가 한 방법...
 * 2. 각 선수 자릿수의 값에 따라서 경우의 수를 나눠 생각하는 방법이 있다.
 */

public class BOJ_영화감독숌_1436 {

	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;
		while( n != cnt) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}

/*
 * contains , valueof 사용법 다시한번 파악해두자 쓸모가 많다.
 * String.valueOf() int를 String으로 변환한다.
 */