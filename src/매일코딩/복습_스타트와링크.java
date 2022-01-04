package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_��ŸƮ�͸�ũ {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		// �ɷ�ġ ���� �Է¹ޱ�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		// ������ ��� ������ ã�� �ּ��� ��� return
		dfs(0,0);
		System.out.println(min);
			
	}
	
	// idx�� �ε���, count�� ���հ���
	public static void dfs(int idx, int count) {
		if(count == N / 2) { // �� ������ �ϼ��Ǵ� ���
			diff(); // �� ���� �ɷ�ġ ���� ����ϴ� �Լ�
			return;
		}
		
		for(int i=idx; i<N; i++) {
			// �湮���� �ʾҴٸ�?
			if(!visited[i]) {
				visited[i] = true;
				dfs(idx+1, count+1); // ���ȣ��
				visited[i] = false; // ��Ͱ� ������ ��湮���� ����
			}
		}
	}
	
	// �ϳ��� ���� �ϼ��� �� �� ���� �ɷ�ġ ���� ����ϴ� �Լ�
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				// i���� ����� j ��° ����� true��� ��ŸƮ������ ���� �÷���
				if(visited[i] == true  && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				
				// i��° ����� j��° ����� false��� ��ũ������ ���� �÷���
				else if(visited[i] == false && visited[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		
		// �� ���� ���� ����(����)
		int val = Math.abs(team_start - team_link);
		
		// ���� �� ���� �������� 0�̶�� ���� ���� �ּڰ��̱� ������
		// ���̻� Ž���� �ʿ� x
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
	}
}
