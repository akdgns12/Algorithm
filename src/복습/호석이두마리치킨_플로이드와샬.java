package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ȣ���̵θ���ġŲ_�÷��̵�ͼ� {
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
		
		// �ִܰŸ� ���̺� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0; // �ڱ��ڽſ��� ���� ��� 0���� �ʱ�ȭ
		}
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		// �÷��̵�ͼ�
		floydWarshall();
		
		int minSum = INF;
		String result = "";
		
		// �� ���� ġŲ���� �����ϰ�(i,j) ��� �ǹ���(k)���� �Ÿ� ���� �� �ּ� ���� ã�´�
		for(int i=1; i<dist.length; i++) {
			for(int j=i+1; j<dist.length; j++) {
				int sum = 0;
				// �ǹ�(k)���� ġŲ ���� �� ����� ������ ���⶧���� (i,k), (j,k)�� �ּҰ��� ���տ� �ִ´�.
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
