package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int answer = a.length();
		
		for(int i=0; i<=b.length()-a.length(); i++) {
			int cnt = 0;
			for(int j=0; j<a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j))
					cnt++;
			}
			answer = Math.min(cnt, answer);
		}
		System.out.println(answer);
	}

}
