package N��M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//BOJ_15655
/*
 * N���� �ڿ��� �߿��� M���� �� ����
 * ��������
 * �ߺ��Ǵ� ���� �ɷ��� �Ѵ�.
 * ����ϴ� ���� ��� �ߺ��Ǹ� �ȵȴ�
 * �޼����� �Ű������� ���� ���۰��� ����� ���� count 2 ���� �Ѵ�
 * for���� ���ۿ��Ҹ� start�� �Ͽ� �ߺ����� �ʵ��� �Ѵ�
 */
public class N��M6 {
	
	static int N,M;
	static int[] arr;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		result = new int[M];
		visited = new boolean[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		if(depth == M) {
			for(int val : result) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
		}else {
		
		for(int i=start; i<N; i++) {
			if(!visited[i]) {	
				visited[i] = true;			// ex) 4,2  : 9 8 7 1
				result[depth] = arr[i];      // ���� �� arr[] = {1, 7, 8, 9}
				dfs(i+1, depth+1);
				visited[i]=false;
				}
			}
		}
	}
}
