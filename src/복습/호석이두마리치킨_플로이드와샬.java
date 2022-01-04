package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호석이두마리치킨_플로이드와샬 {
	static int N, M;
	static int[][] dist;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int[N+1][N+1];
		
		// 최단거리 테이블 초기화
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0; // 자기자신에게 가는 경우 0으로 초기화
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		// 플로이드와샬
		floydWarshall();
		
		int minSum = INF;
		String result = "";
		
		// 두 개의 치킨집을 가정하고(i,j) 모든 건물들(k)과의 거리 총합 중 최소 값을 찾는다
		for(int i=1; i<dist.length; i++) {
			for(int j=i+1; j<dist.length; j++) {
				int sum = 0;
				// 건물(k)에서 치킨 집이 더 가까운 쪽으로 가기때문에 (i,k), (j,k)중 최소값을 총합에 넣는다.
				for(int k=1; k<dist.length; k++) {
					sum += Math.min(dist[i][k],  dist[j][k]);
				}
				
				if(minSum < sum) {
					minSum = sum;
					result = i + " " + j + " " + minSum*2;
				}
			}
		}
	}
	
	public static void floydWarshall() {
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
				}
			}
		}
	}

}
