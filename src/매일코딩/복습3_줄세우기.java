package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습3_줄세우기 {
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 노드의 갯수(사람수)
		M = Integer.parseInt(st.nextToken()); // 간선 갯수
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 그래프의 관계 표현하기 위한2차원 인접리스트
		
		int[] indegree = new int[N+1]; // 해당 노드를 가리키는 노드 갯수를 담기 위한 배열
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			indegree[b]++; // b의 간선증가
		}
		
		topologicalSort(indegree, graph);
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // indegree값이 0이 된 노드들을 담기 위한 Queue
		Queue<Integer> result = new LinkedList<>(); // Queue에서 꺼내져 결과로 출력하기 위해 담는 결과 Queue
		
		// indegree 0인 노드 q에 담기
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0)
				q.offer(i);
		}
		
		// q에서 하나씩 꺼내며 주변 연결된 노드들의 indgree 감소
		// indegree 0이된 노드 q에 담아주기
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
