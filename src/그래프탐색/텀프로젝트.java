package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ��������Ʈ {
	// ������Ʈ ���� ������ ���� �л����� �� ��Ÿ����
	// ����Ŭ �������� ���ϴ� ��� ã��, �ڱ��ڽ� ����Ű�� ��� ����
	static int T;
	static int N;
	static int[] num;
	static boolean[] visited; // �ش� ��带 �湮������ �ִ��� Ȯ���ϴ� �迭
	static boolean[] finished; // boolean �迭 �ϳ� �� �־����.. visited�Ȱ� �ٽ� �湮�� ��� ����Ŭ�� �ϼ��Ǿ����� �˷��ִ� �迭
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); // ���� ����
		
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				num[i] = Integer.parseInt(st.nextToken()); // i�� �л��鿡 ���� ���õ� �л� ��ȣ �迭
			}
			
			for(int i=1; i<=N; i++) {
				dfs(i);
			}
			
			System.out.println(N - count);
		} // end for
	}
	
		public static void dfs(int now) {
			if(visited[now]) { // �湮�� ���
				finished[now] = true; count++;
			}else { // �湮���� ���� ���
				visited[now] = true;
			}
			
			int next = num[now];
			if(!finished[next]) dfs(next);
			visited[now] = false; 
			finished[now] = true;
		}
}
