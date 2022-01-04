package 매일코딩;

import java.util.ArrayList;

public class 전력망둘로나누기 {
	// 2가지 묶음으로 나눠야 한다.
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<wires.length; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=0; i<wires.length; i++) {
			visited = new boolean[n+1];
			int a = wires[i][0];
			int b = wires[i][1];
			visited[a] = true;
			visited[b] = true;
			int start = dfs(a);
			int end = dfs(b);
			
			answer = Math.min(answer, Math.abs(start - end));
		}
		
		return answer;
	}
	
	public static int dfs(int index) {
		int cnt = 1;
		visited[index] = true;
		for(int i=0; i<list[index].size(); i++) {
			if(visited[(int)list[index].get(i)]) continue;
			cnt += dfs((int)list[index].get(i));
		}
		return cnt;
	}
}
