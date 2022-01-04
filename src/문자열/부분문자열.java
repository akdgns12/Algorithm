package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열 {
	// BOJ 16916 부분문자열 / 골 4
	// P가 S의 부분문자열이면 1, 아니면 0
	static String P, S;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine(); 
		P = br.readLine();
		 
	}
}
