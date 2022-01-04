package 신한은행유사문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자해독 {
	// BOJ 1593 / 슬라이딩윈도우 / S의 모든 인덱스마다 모든 g 크기만큼 비교해서 구한다.
	static String w, s;
	static int wLen; // w의 길이
	static int sLen; // 문자열 s의 길이
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		wLen = Integer.parseInt(st.nextToken());
		sLen = Integer.parseInt(st.nextToken());
		
		char[] w = br.readLine().toCharArray();
		char[] s = br.readLine().toCharArray();
		
		/*
		 * w의 각각의 알파벳의 등장횟수를 그 알파벳에 해당하는 칸에 +1을 해준다.
		 * 그리고 s의 처음부터 w길이만큼 끊어서 비교하는데
		 * 그 구간에 w와 s에 등장하는 알파벳의 횟수가 일치한다면 w의 순열로 s를
		 * 만들 수 있다는 뜻이기 때문에 answer++;
		 */
		/*
		 * 슬라이딩 윈도우
		 * w의 길이만큼 s의 문자열 내에서 슬라이딩 윈도우 해나간다.
		 */
		
		// 대문자, 소문자 총 52개 들어갈 배열 
		int[] wAlpha = new int[52];
		// 알파벳 순서대로 마킹 해준다.
		for(int i=0; i<wLen; i++) {
			if(w[i] < 'a') wAlpha[w[i] - 'A']++;
			else wAlpha[w[i] - 'a' + 26]++;
		}
	
		int[] sAlpha = new int[52];
		int next, len = 0, answer = 0, from = 0;
		// 문자열 m의 알파벳 마킹
		for(int i=0; i<sLen; i++) {
			if(s[i] < 'a') // 대문자일 경우
				next = s[i] - 'A';
			else
				next = s[i] - 'a' + 26;
			
			len++;
			sAlpha[next]++;
			if(len == wLen) { // 길이를 wLen만큼 늘려 주고 그 길이가 같을 때
				if(same(wAlpha, sAlpha)) answer++;
				
				// 이 작업이 슬라이딩 윈도우 다음 번 비교하기 위해 
				// 슬라이딩 윈도우 앞부분 늘리고 뒷부분 줄이는 작업
				// 길이 len으로 만들어진 슬라이딩 윈도우
				// sAlpha from인덱스값 빼주고 from 하나 증가시켜서
				// 슬라이딩 윈도우 사이즈 고정시켜 이동할 수 있도록 해준다.
				if(s[from] < 'a') sAlpha[s[from] - 'A']--;
				else sAlpha[s[from] - 'a' + 26]--;
				from++;
				len--;
			}
		}
	}
	
	public static boolean same(int[] w, int[] s) {
		for(int i=0; i<52; i++)
			if(w[i] != s[i]) return false;
		return true;
	}

}
