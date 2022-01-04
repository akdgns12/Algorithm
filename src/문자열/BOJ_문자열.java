package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B문자열을 하나씩 A문자열만큼 돌면서
 * A문자열과의 차이가 가장 적을 때 그 차이를
 * 출력하면 되는 문제
 * 
 */
public class BOJ_문자열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		int answer = A.length();
		
		for(int i=0; i<B.length() - A.length(); i++) {
			int cnt = 0;
			for(int j=0; j<A.length(); j++) {
				if(A.charAt(j) != B.charAt(i+j))
					cnt++;
			}
			answer = Math.min(cnt, answer);
		}
		System.out.println(answer);
		
	}
}
