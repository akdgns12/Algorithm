package ¹®ÀÚ¿­;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_LCS3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		String s3 = br.readLine();
		
		int len = getLCS(s1, s2, s3);
		
		bw.write(len + "\n");
		bw.flush();
	}
	
	public static int getLCS(String s1, String s2, String s3) {
		int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		
		for(int i=1; i<=s1.length(); i++) {
			char c1 = s1.charAt(i-1);
			
			for(int j=1; j<=s2.length(); j++) {
				char c2 = s2.charAt(j-1);
				
				for(int k=1; k<=s3.length(); k++) {
					char c3 = s3.charAt(k-1);
					
					if(c1 == c2 && c2 == c3)
						dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
					else
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k],  dp[i][j][k-1]));
				}
			}
		}
		
		return dp[s1.length()][s2.length()][s3.length()];
	}
}
