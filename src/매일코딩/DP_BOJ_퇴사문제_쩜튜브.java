package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���Ʈ���� DFS�� Ǯ�� ���
 * idx���� n�ϱ��� ���� �� �ִ� ������ Ȯ���� �� �����ϴٸ� ������ �Ѵ�.
 * idx���� ���� �ʴ� ��쵵 üũ�Ѵ�.
 * idx == n�̸� ����� �����Ƿ� max�����ϰ� �����Ѵ�.
 * 
 */
public class DP_BOJ_��繮��_��Ʃ�� {
	static int n;
	static int max = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken()); // ���Ⱓ
			map[i][1] = Integer.parseInt(st.nextToken()); // ���Ա�
		}
		
		dfs(0, 0); // idx, sum(�����, ���Ա�)
		System.out.println(max);
	}
	
	public static void dfs(int idx, int sum) {
		if(idx == n) { // �� �� ����� �����Ƿ� max �����ϰ� ����
			max = Math.max(max,  sum);
			return;
		}
		
		if(idx + map[idx][0] <= n) {
			dfs(idx + map[idx][0], sum + map[idx][1]);
		}
			dfs(idx + 1, sum);
	}

}
