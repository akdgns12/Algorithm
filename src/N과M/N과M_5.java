package N��M;


// N��M (5) ��Ʈ��ŷ ����
// DFS�� ������������ �湮�� ���� ������ ���ȣ���� �̿��ؼ� ��� �̵��ϴ� ��.
// ��Ʈ��ŷ�� DFS�� ����ġ�⸦ ���� �������� �ʴ� ��Ʈ�� ������� �ʰ� Ž���ϴ� ����Ž�� ���
// �Է¹��� ������ ������������ �����ϸ�
// �湮 �迭�� ����� �ߺ��� ���� ���� �Ѵ�.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N��M_5{
	
	static int N,M;
	static int[] array, result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		result = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		// ī��Ʈ ���� �ڿ��� M�� ���ٸ�
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] == true) continue; // continue �ش� �ݺ� �κи� Ż���ϰ� ������ �ݺ��� �̾�Ѵ�.
			visited[i] = true; // ���° ������ true false;
			result[depth] = array[i];
			dfs(depth + 1);
			visited[i] = false;
		}
	}
}