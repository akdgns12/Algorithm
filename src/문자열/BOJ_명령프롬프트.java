package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_���������Ʈ {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =  Integer.parseInt(br.readLine());
		
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		
		boolean dif = false;
		
		for(int i=0; i<str[0].length(); i++) {
			dif = false;
			for(int j=0; j<n-1; j++) {
				if(str[j].charAt(j) != str[j+1].charAt(i)) {
					dif = true;
					break;
				}
			}
			
			if(dif)
				System.out.println("?");
			else
				System.out.println(str[0].charAt(i));
		}
		
		
		
	}
}
