package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 팰린드롬만들기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character, Integer> map = new HashMap<>();
		//map 에 'a' 1 'b' 2 이런식으로 값 넣어주고
		//
		int n = Integer.parseInt(br.readLine());
		String input;
		for(int i=0; i<n; i++) {
			char[] c = br.readLine().toCharArray();
			
		}
	}

	public static void dfs() {
		
	}
}
