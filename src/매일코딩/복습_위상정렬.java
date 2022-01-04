package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_위상정렬 {
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 갯수(사람 수)
		M = Integer.parseInt(st.nextToken()); // 간선의 갯수
		
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		// 그래프 초기화
		for(int i=0; i<N+1; i++	) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 방향 그래프의 모든 간선 정보 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b); // 정점 a에서 b로 이동가능
			//진입차수(간선이 생겼으므로) 1증가
			indegree[b]++;
		}
		
		topologicalSort(indegree, graph);
	}

	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // 간선의 갯수가 0인 노드가 들어갈 큐
		Queue<Integer> result = new LinkedList<>(); // 순서에 대한 결과가 들어갈 큐
		
		// indegree가 0인 노드 Queue에 넣기
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		
		// q에서 노드를 하나씩 빼며 연결된 노드의 indegree 감소
		// indegree가 0이 된 노드들 Queue에 넣기
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
