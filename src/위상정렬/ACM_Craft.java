package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACM_Craft {
	// 백준 1005 ACM_Craft / 골 3 / 위상정렬같은데?
	/*
	 * a->b 방향은 있는데 b->a가 성립하지 않는 
	 * 방향은 있지만 사이클이 없는 그래프(DAG) -> 위상정렬
	 */
	// 일반적인 위상정렬과 다른점 .. 노드의 순서가 아니라 소요시간을 기억해야 한다
	// result 배열을 만들어 총 소요시간 저장해두자
	/*
	 * 1. 처음 indegree가 0인 건물들은 이전 테크가 없기 떄문에 총 소요시간이 d[i]
	 * 2. Queue에서 건물을 빼면서 해당 거눔ㄹ과 연결된 다른 건물들의 result를 갱신해준다
	 * 3. 이전까지의 소요시간 result[node] + 현재 건물의 소요시간 d[i]로 이루어지며
	 * 이전 테크가 전부 올라가야 현재 건물을 지을 수 있기 때문에 가장 오래 걸리는 시간으로 갱신해준다.(Math.max)사용
	 */
	static int N, K; // 노드 개수, 간선 개수
	static int[] d;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			d = new int[N+1];
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++)
				list.add(new ArrayList<Integer>());
			
			int[] indegree = new int[N+1]; // 해당 노드를 가리키는 간선의 개수 담기 위한 배열
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				d[i] = Integer.parseInt(st.nextToken()); // 각 건물의 건설시간
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				// a -> b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				indegree[b]++; // b를 가리키는 간선개수 증가
			}
		
			int W = Integer.parseInt(br.readLine());
			
			topologicalSort(indegree, list, W);
		} // end of TC
		
		
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> list, int W) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[N+1];
		
		// 건물짓는 기본 시간은 d[i]
		for(int i=1; i<=N; i++) {
			result[i] = d[i];
			
			if(indegree[i] == 0) { // 진입차수가 0인 노드들을 큐에 삽입
				q.offer(i);
			}
		}
		
		// 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
		// Max 해주는 이유는 이전 테크가 다 올라야 현재 건물을 지을 수 있기 때문
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : list.get(node)) {
				result[i] = Math.max(result[i], result[node] + d[i]);
				indegree[i]--;
				
				if(indegree[i] == 0)
					q.offer(i);
			}
		}
		
		System.out.println(result[W]);
	}
}
