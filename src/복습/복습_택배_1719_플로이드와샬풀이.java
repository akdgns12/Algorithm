package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 복습_택배_1719_플로이드와샬풀이 {
	static int N, M;
	static int[][] map;
	static int[][] graph;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		graph = new int[N+1][N+1];
		
		for(int i=0; i<N+1; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0; // 자기 자신은 0으로 초기화
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[start][end] = cost;
			graph[end][start] = cost;
			
			map[start][end] = start;
			map[end][start] = end;
		}
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
						map[i][j] = k;
					}
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i == j) sb.append("- ");
				else sb.append(map[i][j] + " ");
			}sb.append("\n");
		}
			
		System.out.println(sb.toString());
		
	}

}
