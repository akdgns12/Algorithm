package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tournament {
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		
		int Kim = Integer.parseInt(st.nextToken());
		
		int Lim = Integer.parseInt(st.nextToken());
		
		int round = 0;
		// 간단한 수학문제 !
		while(Kim != Lim) {
				Kim = Kim/2 + Kim%2;
				Lim = Lim/2 + Lim%2;
				round++;
		}
		System.out.println(round);
	}
}
