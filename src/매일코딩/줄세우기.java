package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1. 값을 저장해준다 Arraylist를 이용하여
 * 2. indegree가 0인 값을 큐에 모두 집어넣는다
 * 3. 큐가 빌때까지 0인 값을 하나씩 빼서 그 다음 값을 다시 큐에 집어 넣는다(단 그 때 화살표 값인 indegree를 하나씩 줄인다)
 */
public class 줄세우기 {
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점 갯수(사람 
		M = Integer.parseInt(st.nextToken()); // 간선 갯수
		
		// 자기한테 온 간선의 갯수
		int[] indegree = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 이차원 ArrayList를 이용하여 단방향성 그래프를 생성해주고 가리킴을 받는 간선의 indegree[index]의 간선의 갯수를 증가해준다.
																// 그리고 위상정렬 해준다.
		// 그래프 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		
		// A가 B앞에 서야한다는 뜻(학생 번호는 1~N)
		// 방향 그래프의 모든 간선 정보를 입력받기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // A학생 번호
			int b = Integer.parseInt(st.nextToken()); // B학생 번호
			
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		// 입력끝
		
		
		topologicalSort(indegree, graph);
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new LinkedList<>(); // 간선의 갯수가 0인 정점이 들어갈 큐
		Queue<Integer> result = new LinkedList<>(); // 순서에 대한 결과가 들어갈 큐
	
		int current;
		while(!q.isEmpty()) {
			current = q.poll();
			result.offer(current);
			
			for(int i : graph.get(current)) {
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
