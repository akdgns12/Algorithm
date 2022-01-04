package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 접미사배열 {
	public  static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		ArrayList<String> result = new ArrayList<>();
		
		
		for(int i=0; i<s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(s.charAt(i));
			for(int j=i+1; j<s.length(); j++) {
				sb.append(s.charAt(j));
			}
			result.add(sb.toString());
		}
		
		Collections.sort(result);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
