package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트 {
	// 프로젝트 팀에 속하지 못한 학생들의 수 나타내라
	// 싸이클 형성하지 못하는 노드 찾기, 자기자신 가리키는 노드 제외
	static int T;
	static int N;
	static int[] num;
	static boolean[] visited; // 해당 노드를 방문한적이 있는지 확인하는 배열
	static boolean[] finished; // boolean 배열 하나 더 있어야함.. visited된곳 다시 방문한 경우 싸이클이 완성되었음을 알려주는 배열
	static int count;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine()); // 테케 개수
		
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N+1];
			visited = new boolean[N+1];
			finished = new boolean[N+1];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				num[i] = Integer.parseInt(st.nextToken()); // i번 학생들에 의해 선택된 학생 번호 배열
			}
			
			for(int i=1; i<=N; i++) {
				dfs(i);
			}
			
			System.out.println(N - count);
		} // end for
	}
	
		public static void dfs(int now) {
			if(visited[now]) { // 방문한 노드
				finished[now] = true; count++;
			}else { // 방문한적 없는 노드
				visited[now] = true;
			}
			
			int next = num[now];
			if(!finished[next]) dfs(next);
			visited[now] = false; 
			finished[now] = true;
		}
}
