package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열_골드4_BOJ {
		
		static int answer = 0;
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String origin = br.readLine();
			String pattern = br.readLine();
			
			KMP(origin,pattern);
			
			System.out.println(answer);
	}
		
		public static int[] getPi(String pattern) {
			int[] pi = new int[pattern.length()];
			int j = 0;
			for(int i=1; i<pattern.length(); i++) {
				while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
					j = pi[j-1];
				}
				if(pattern.charAt(i) == pattern.charAt(j))
					pi[i] = ++j;
			}
			return pi;
		}
		
		public static void KMP(String origin, String pattern) {
			int[] pi = getPi(pattern);
			int j = 0;
			for(int i=0; i<origin.length(); i++) {
				while(j > 0 && origin.charAt(i) != origin.charAt(j)) {
					j = pi[j-1];
				}
				if(origin.charAt(i) == origin.charAt(j)) {
					if(j == pattern.length() - 1) {
						answer = 1;
						break;
					}
					else
						j++;
				}
					
			}
		}
}
