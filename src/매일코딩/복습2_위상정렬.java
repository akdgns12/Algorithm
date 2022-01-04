package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습2_위상정렬 {
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 개수(사람 수)
		M = Integer.parseInt(st.nextToken()); // 간선 개수
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[N+1];
		// 그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 방향 그래프의 모든 간선정보 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++; // 간선하나 증가하므로 indegree++
		}
		
		topologicalSort(indegree, graph);
		
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // indegree가 0인 노드를 담을 큐
		Queue<Integer> result = new LinkedList<>(); // 결과 순서를 담을 큐
		
		// indegree가 0인 노드 q에 넣기
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		// q에서 노드를 하나씩 빼며 연결된 노드의 indegree감소
		// indegree가 0이 된 노드들 q에 넣기
		while(!q.isEmpty()) {
			int node = q.poll();
			result.offer(node);
			
			for(int i : graph.get(node)) {
				indegree[i]--;
				
				if(indegree[i] == 0)
					q.offer(i);
			}
		}
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
	}

}
