package ½Ã¹Ä·¹ÀÌ¼Ç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ¹ì {
	static String[] table;
	static String[] languages;
	static String[] preference;
	
	static String[] solution(String[] table) {
		ArrayList<String> table_sc = ArrayList<String>();
		String answer = "";
		while(table_sc.hasMoreTokens()) {
			if(languages[j] == table)
		}
		
		return answer;
	}
	
	static public void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		table = new String[5];
		languages = new String[10];
		preference = new String[10];
		
		
		for(int i=0; i<5; i++) {
			table[i] = st.nextToken();	
			
		}
		
			for(int j=0; j<10; j++) {
			languages[j] = br.readLine();
			}
				for(int k=0; k<10; k++) {
					preference[k] = st.nextToken();
				}
				solution()
				System.out.println(answer);
	}
}
