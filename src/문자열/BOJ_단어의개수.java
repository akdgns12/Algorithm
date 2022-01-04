package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_단어의개수 {
	/*
	 * 단어는 최소 4글자 이상, 한글자는 1번씩만 사용 -> 10글자 이상의 단어는 못만듦
	 * 표의 정중앙 글자는 반드시 사용해야 함.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		System.out.println(st.countTokens());
		
	}
}
