package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 서로다른부분문자열의개수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// S의 서로 다른 부분 문자열의 개수 구하라
		String input = br.readLine(); 	// 문자열 S
		HashSet<String> set = new HashSet<>();
		
		String name = "";
		
		for(int i=0; i<input.length(); i++) {
			name = "";
			// i부터 끝까지 반복을 하여 set에 넣는데 중복이 있으면 안넣는다
			for(int j=i; j<input.length(); j++) {
				name += input.substring(j,j+1);
				set.add(name);
			}
		}
		
		System.out.println(set.size());
		
	}
}
