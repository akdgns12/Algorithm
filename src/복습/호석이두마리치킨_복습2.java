package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ȣ���̵θ���ġŲ_����2 {
	static int N,M;
	static int[][] dist;
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1];
		// �׷��� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		floydWarshall();
		int minSum = Integer.MAX_VALUE;
		String result = "";
		// �� ���� ġŲ���� �����ϰ�(i,j) ��� �ǹ���(k)���� �Ÿ� ���� �� �ּҰ��� ã�´�.
		for(int i=1; i<dist.length; i++) {
			for(int j=i+1; j<dist.length; j++) {
				int sum = 0;
				// �ǹ�(k)���� ġŲ ���� �� ����� ������ ���� ������(i,k)(j,k) �� �ּҰ��� �ִ´�.
				for(int k=1; k<dist.length; k++) {
					sum += Math.min(dist[i][k], dist[j][k]);
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
					dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
				}
			}
		}
	}
}
