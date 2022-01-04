package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 고냥이_복습2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int st = 0;
		int end = 0;
		int max = 0;
		
		while(st <= end && end <= s.length() - 1) {
			String str = s.substring(st, end+1);
			if(end == s.length()) break;
			if(isCount(str) >= N) {
				end--;
			}else if(isCount(str) < N) {
				end++;
			}
			if(isCount(str) == N) {
				max = Math.max(max, str.length());
				break;
			}
		}
		
		System.out.println(max);
	}
	// 만들어진 문자열안에 있는 문자의 종류 return
	public static int isCount(String str) {
		HashSet<Character> hs = new HashSet<>();
		
		for(int i=0; i<str.length(); i++) {
			hs.add(str.charAt(i));
		}
		
		return hs.size();
	}
}
