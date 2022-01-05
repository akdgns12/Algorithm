package 그래프탐색;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21278 {
	// 호석이 두마리치킨 / 골5 / 다익스트라
	/*
	 * 모든 정점으로부터 모든 정점까지의 최단거리 -> 다익스트라? (X)
	 * 플로이드 와샬
	 * 2차원 테이블에 �C나거리 정보를 저장
	 * 플로이드 와샬 알고리즘은 dp에 속함
	 */
	static int N, M;
	static final int INF = (int)1e9;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		// 최단거리 테이블을 모두 무한으로 초기화
		for(int i=1; i<=N; i++) {
			Arrays.fill(graph[i], INF);
			//3. 과정 여기서 한번에 처리할 수 있다.
			graph[i][i] = 0;
		}
		
//		// 3.자기자신으로 가는 비용은 모두 0으로 초기화
//		for(int a=1; a<=N; a++) {
//			for(int b=1; b<=N; b++) {
//				if(a == b) graph[a][b] = 0;
//			}
//		}
//		
		// 간선 정보 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}                           
		
		floydWarshall();
		
		int minSum = Integer.MAX_VALUE;
		String result = "";
		
		for(int i=1; i<graph.length; i++) {
			for(int j=i+1; j<graph.length; j++) {
				int sum = 0;
				// 건물(k)에서 치킨 집이 더 가까운 쪽으로 가기 때문에 (i,k) (j,k) 중 최소 값을 총합에 넣습니다.
				for(int k=1; k<graph.length; k++) {
					sum += Math.min(graph[i][k], graph[j][k]);
				}
				
				if(minSum > sum) {
					minSum = sum;
					result = i + " " + j + " " + minSum*2;
				}
			}
		}
		System.out.println(result);
	}
	
	public static void floydWarshall() {
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
				}
			}
		}
	}
}
