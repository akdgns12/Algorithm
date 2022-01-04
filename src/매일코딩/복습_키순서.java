package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_Ű���� {
	static int N,M; // N : �л��� ��, M : ������ ��
	static int a,b; // input �޴� �л� a,b
	static int[][] dist; // �÷��̵�ͼ��� ���� 2���� �迭
	static final int INF = (int)1e9; // �ʱ�ȭ�� ���� �Ұ����� �ִ�
	static int answer; // ����� ����
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1. 2���� �迭 INF(�ִ�)���� �ʱ�ȭ
		dist = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				dist[i][j] = INF;
			}
		}
		
		// 2. �Է� : a - b �л��� Ű ������ �ƴ� ��� 1�� �Ÿ� �迭 �Է�
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			dist[a][b] = 1;
		}
		
		// 3. Ư�� �л��� ��� �л����� �Ÿ��� üũ�ؾ��ϹǷ� �÷��̵� �ͼ� ����
		// �÷��̵� �ͼ� : ������ - ����� - ������ 3�� for��
		for(int k=1; k<=N; k++) {
			for(int a=1; a<=N; a++) {
				for(int b=1; b<=N; b++) {
					// dist[i][j] ���� ���� �� ���� ��� ����
					dist[a][b] = Math.min(dist[a][b], dist[a][k] + dist[k][b]);
				}
			}
		}
		
		// 4. ��� �л����� �񱳰� ������ ���
		// -> �Ÿ��� INF�� �ƴ� �л��� ���� N-1�� ��� : Ű�� ���°���� �� �� �����Ƿ� answer++
		answer = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			for(int j=1; j<=N; j++) {
				if(dist[i][j] != INF || dist[j][i] != INF)
					cnt++;
			}
			if(cnt == N-1) answer++;
		}
		System.out.println(answer);
	}
}
