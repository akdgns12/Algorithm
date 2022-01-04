package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		HashSet<String> set = new HashSet<>();
		
		for(int i=0; i<S.length(); i++) {
			String name = "";
			
			for(int j=i; j<S.length(); j++) {
				name += S.substring(j, j+1);
				set.add(name);
			}
		} 
		
		System.out.println(set.size());
	}
}
