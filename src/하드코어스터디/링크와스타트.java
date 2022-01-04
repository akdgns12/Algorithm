package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ũ�ͽ�ŸƮ {
	// BOJ 15661 ��ũ�ͽ�ŸƮ / �ǹ� 1
	// �� ���� �ɷ�ġ ���� �ּ�ȭ
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int num = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �� ���� �������� ���ϴ� ����� ���� ����
		// �ɷ�ġ ���� ��� ���ϰ� �� �� �ּڰ� ����
		for(num = 1; num<N; num++) { // num : ���� ��
			combi(0,0);
		}
		
		System.out.println(min);
	}
	// ������ �Ǵ� �ο� �� ��� ���ϱ�
	public static void combi(int depth, int start) {
		if(depth == num) {
			calc();
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				combi(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	// �ɷ�ġ ���
	public static void calc() {
		 int start = 0; // visited[i] = true : start��
		 int link = 0; // visited[i] = false : link��
		 for(int i=0; i<N; i++) {
			 for(int j=i+1; j<N; j++) {
				 if(visited[i] && visited[j]) {
					 start += (map[i][j] + map[j][i]);
				 }else if(!visited[i] && !visited[j]) {
					 link += (map[i][j] + map[j][i]);
				 }
			 }
		 }
		 
		min = Math.min(min, Math.abs(start-link)); // �ּڰ� ����
		
		if(min == 0) { // �ɷ�ġ �� 0�̸� �ٷ� ���� �� �����ӵ� ����
			System.out.println(0);
			System.exit(0);
		}
	}
}
