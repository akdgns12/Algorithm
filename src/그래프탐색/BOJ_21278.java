package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21278 {
	// ȣ���� �θ���ġŲ / ��5 / ���ͽ�Ʈ��
	/*
	 * ��� �������κ��� ��� ���������� �ִܰŸ� -> ���ͽ�Ʈ��? (X)
	 * �÷��̵� �ͼ�
	 * 2���� ���̺� �C���Ÿ� ������ ����
	 * �÷��̵� �ͼ� �˰����� dp�� ����
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
		
		// �ִܰŸ� ���̺��� ��� �������� �ʱ�ȭ
		for(int i=1; i<=N; i++) {
			Arrays.fill(graph[i], INF);
			//3. ���� ���⼭ �ѹ��� ó���� �� �ִ�.
			graph[i][i] = 0;
		}
		
//		// 3.�ڱ��ڽ����� ���� ����� ��� 0���� �ʱ�ȭ
//		for(int a=1; a<=N; a++) {
//			for(int b=1; b<=N; b++) {
//				if(a == b) graph[a][b] = 0;
//			}
//		}
//		
		// ���� ���� �Է¹ޱ�
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
				// �ǹ�(k)���� ġŲ ���� �� ����� ������ ���� ������ (i,k) (j,k) �� �ּ� ���� ���տ� �ֽ��ϴ�.
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
