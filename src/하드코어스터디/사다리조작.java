package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��ٸ����� {
	static int N, M, H;
	static int[][] map;
	static int answer;
	static boolean isFinish = false; // ���Ǹ��� �Ǻ� ���� ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		 
		map = new int[H+1][N+1];
		for(int i=0; i<M; i++) { // ���μ� ����
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // x ��ǥ
			int b = Integer.parseInt(st.nextToken()); // y ��ǥ
			// 0 : ���μ� ����, 1 : ������� ������, 2 : ������� ����
			map[a][b] = 1;
			map[a][b+1] = 2;
		}
		
		// ���μ� ���� 3�� �����Ǿ� ������
		// ��ġ�� �ٸ� ���� 0~3��
		for(int i=0; i<=3; i++) {
			// ��ġ�� ��ٸ� ������ ���������� �����ϰ�dfs�� ��� ���̰� �ش� �� ��ŭ ����ǵ��� �Ѵ�.
			answer = i;
			dfs(0,1);
			if(isFinish) break;
		}
		
		System.out.println(isFinish ? answer : -1);
	}
	
	public static void dfs(int line, int start) {
		if(isFinish) return;
		if(answer == line) { // answer ������ŭ �������� ������ٸ�
			if(check()) isFinish = true; // ������ �����ϴ��� Ȯ���Ͽ� isFinish ���� �ٲ��ش�.
			return;
		}
		
		// �� ��ü Ž���ϸ鼭 ���μ� �����
		for(int i=start; i<=H; i++) {
			for(int j=1; j<N; j++) {
				if(map[i][j] == 0 && map[i][j+1] == 0) { // ���μ��� ���� ���̶�� 
					map[i][j] = 1; // ���μ� ��ġ�� ���� ������� �������ش�
					map[i][j+1] = 2;
					dfs(line+1, i); // ���μ��� ���� + 1, ���� Ž�� ��ġ�� �Ű������� ���ȣ��
					map[i][j] = map[i][j+1] = 0; // �� ����
				}
			}
		}
	}
	// i������ ����� i���� �����ϴ��� üũ�ϴ� �Լ�
	public static boolean check() {
		for(int i=1; i<=N; i++) { // �� ������ Ž��
			int nx = 1; // �����ϴ� ������
			int ny = i; // �����ϴ� ������
			
			while(nx <= H) { // �������� ������ Ž��
				if(map[nx][ny] == 1) ny++; // ���������� �̵��ؾ� �ϴ� ���
				else if(map[nx][ny] == 2) ny--; // �������� �̵��ؾ� �ϴ� ���
				nx++; // �����ٷ� ��������
			}
			// �������� ���� ������ �� i���� ���μ��� ����� i���� �������� Ȯ��
			if(ny != i) return false;
		}
		return true;
	}
}
