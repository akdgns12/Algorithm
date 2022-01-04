package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 문자열
// 즉, 문자열 S안에서 문자열 W의 순열 중 하나가 부분 문자열로 들어있는
// 모든 경우의 수를 계산하라

// w의 문자들로 만들 수 있는 모든 순열 생성 후 검사하면 시간초과
// 검사해야하는 문자열의 길이는 고정이기 때문에 슬라이딩 윈도우 기법을 사용하여
// 구간을 검사
public class 문자해독 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int g = Integer.parseInt(st.nextToken()); // W단어의 길이
		int s = Integer.parseInt(st.nextToken()); // S단어의 길이
		String W = br.readLine(); // W단어
		String S = br.readLine(); // S단어
		
		int[] word = new int[26*2]; // 대문자 26, 소문자 26
		int[] sentence = new int[26*2];
		
		for(int i=0; i<g; i++) {
			if(W.charAt(i) >= 'a' && W.charAt(i) <= 'z') {
				word[W.charAt(i) - 'a'] += 1;
			}else {
				word[W.charAt(i) - 'A' + 26] += 1;
			}
		}
		
		int start= 0;
		int length = 0;
		int count = 0;
		
		// 문자열 S에 대해 슬라이딩 윈도우
		for(int i=0; i<s; i++) {
			if(S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
				sentence[S.charAt(i) - 'a'] += 1;
			}else {
				sentence[S.charAt(i) -'A' + 26] += 1;
			}
			length += 1;
			
			if(length == g) {
				if(word[i] == sentence[i]) {
					count += 1;
				}
				if(sentence[start] >= 'a' && sentence[start] <= 'z') {
					sentence[S.charAt(i) - 'a'] -= 1;
				}else {
					sentence[S.charAt(i) - 'A' + 26] -= 1;
				}
				start += 1;
				length -= 1;
			}
	
		} // end for
	}
}
