package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습3_위상정렬 {
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 개수 ( 사람 수)
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프의 관계를 나타내기 위한 2차원 인접리스트
		
		int[] indegree = new int[N+1]; // 해당 노드를 가리키는 간선 갯수를 담기위한 배열
		
		// 그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			// a -> b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++; // b의 간선 증가
		}
		
		topologicalSort(indegree, graph);
		
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph)	{
		Queue<Integer> q = new LinkedList<>(); // indegree 0인 노드를 담을 큐
		Queue<Integer> result = new LinkedList<>(); // 정렬 결과를 담을 큐
		
		// indegree가 0인  노드를 q에 담아줌
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0)
			q.offer(i);
		}
		
		// q에서 하나씩 빼며 연결된 노드의 indegree 감소
		// indegree가 0인 노드 q에 넣기
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
