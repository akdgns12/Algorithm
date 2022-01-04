package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// ���� �ɷ�ġ ���� �ּ�ȭ
/*
 * ��� ������ ����� ���� Ž���Ͽ� �� ���� �ɷ�ġ�� �ּҰ� �Ǵ� ���� ã��
 * �̸� ����ϸ� �ȴ�.
 */
public class ��ŸƮ�͸�ũ {
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		// ����ǥ �Է�
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of Input
		
		combi(0,0);
		System.out.println(min);
	}
	// idx�� �ε���, count�� ���� ����(=��� ����)
	public static void combi(int idx, int count) {
		// �� ������ �ϼ��� ���
		if(count == n / 2) {
			/*
			 *  �湮�� ���� �湮���� ���� ���� ���� ������
			 *  �� ���� ������ ���� �� �ּڰ��� ã�´�.
			 */
			diff();
			return;
		}
		
		for(int i=idx; i<n; i++) {
			// �湮���� �ʾҴٸ�?
			if(!visited[i]) {
				visited[i] = true; // �湮���� ����
				combi(i + 1, count + 1); // ��� ȣ��
				visited[i] = false; // ��Ͱ� ������ ��湮���� ����
			}
		}
	}
	
	// �� ���� �ɷ�ġ ���̸� ����ϴ� �Լ�
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				// i��° ����� j��° ����� true��� ��ŸƮ������ ���� �÷���
				if(visited[i] == true && visited[j] == true) {
					team_start += map[i][j];
					team_start += map[j][i];
				}
				// i��° ����� j���� ����� false��� ��ũ������ ���� �÷���
				else if(visited[i] == false && visited[j] == false) {
					team_link += map[i][j];
					team_link += map[j][i];
				}
			}
		}
		// �� ���� ���� ����(����)
		int val = Math.abs(team_start - team_link);
		
		/*
		 * �� ���� �������� 0�̶�� ���� ���� �ּڰ��̱� ������
		 * ���̻��� Ž�� �ʿ���� 0�� ����ϰ� �����ϸ� �ȴ�.
		 */
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		
		min = Math.min(val, min);
	}
}
