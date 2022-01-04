package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 복습_ACM_Craft {
	static int N, K;
	static int[] d; // 각 건물 소요시간
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			d = new int[N+1];
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<N+1; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			int[] indegree = new int[N+1]; // 현재 노드까지의 간선개수 저장할 배열
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) { // 각 건물 소요시간
				d[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				
				// a->b
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				indegree[b]++;
			}
			
			int W = Integer.parseInt(br.readLine());
			
			topologicalSort(indegree, list, W);
		}
	}
	
	public static void topologicalSort(int[] indegree, ArrayList<ArrayList<Integer>> list, int W) {
		Queue<Integer> q = new LinkedList<>();
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			result[i] = d[i];
			
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		// 건물의 총 소요시간 = 이전까지의 소요시간 + 현재건물 소요시간
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(Integer i : list.get(node)) {
				result[i] = Math.max(result[i], result[node] + d[i]);
				indegree[i]--;
				
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
			
			System.out.println(result[W]);
		}
		
	}
}
