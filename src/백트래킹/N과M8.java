package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M8 {
	static int N,M;
	static int[] map;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // N개의 자연수
		M = Integer.parseInt(st.nextToken()); // 자연수 M
		// 조건을 만족하는 길이가 M인 수열을 모두 구하라
		/*
		 * N개중 M개
		 * 같은 수 여러번 골라도 됨.
		 * 수열의 길이 오름차순
		 */
		map = new int[N];
		result = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		StringBuilder sb = new StringBuilder();
		
		combi(0,0,sb);
		
		System.out.println(sb);
	}
	
	public static void combi(int start, int cnt, StringBuilder sb) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
		}
		
		for(int i=start; i<N; i++) {
			result[cnt] = map[i];
			combi(i, cnt+1, sb);
		}
	}
}
