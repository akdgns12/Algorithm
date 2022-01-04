package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ��Ƽ {
	// BOJ 1248 ��Ƽ / ��3 / ���ͽ�Ʈ��
	/*
	 * 1. �� �������� ��Ƽ�� ������ X�� ������ ���� ����� �ִܰŸ�
	 * 2. X�� �������� �� ������ ���� ����� �ִܰŸ�
	 * �ΰ� ���� �� �ð� ���� �����ɸ��� ��� 
	 */
	static class Node implements Comparable<Node>{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
	    @Override
	    public int compareTo(Node other) {
	    	return distance - other.distance;
	}
	}
	static int N,M,X;
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> goList, backList;
	static int[] list, back;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // �л� ��(�������� ��������)
		M = Integer.parseInt(st.nextToken()); // ���� ����
		X = Integer.parseInt(st.nextToken()); // ���̴� ���� ��ȣ
		
		goList = new ArrayList<>();
		backList = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			goList.add(new ArrayList<>());
			backList.add(new ArrayList<>());
		}
		
		list = new int[N+1];
		back = new int[N+1];
		Arrays.fill(list, INF);
		Arrays.fill(back, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken()); // �ɸ��� �ð�
			
			goList.get(a).add(new Node(b,cost));
			backList.get(b).add(new Node(a,cost)); 
		}
		
		dijkstra(goList, X, list); // ��Ƽ�� ������ ������ ���� ���
		dijkstra(backList, X, back); // ���ƿ��� ���
		
		int max = 0;
		for(int i=1; i<=N; i++)
			max = Math.max(max, list[i]+back[i]);
		
		System.out.println(max);
	}
	
	public static void dijkstra(ArrayList<ArrayList<Node>> array, int start, int[] cost) {
		boolean[] visited = new boolean[N+1]; // �湮 ���� üũ�迭
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		pq.add(new Node(start, 0)); // ���� ���� ť�� ����
		cost[start] = 0; // ���� ��� �ʱ�ȭ
		
		while(!pq.isEmpty()) {
			int now = pq.poll().index;
			
			if(visited[now]) continue; // �̹� �湮�ߴ� ���̶�� �Ѿ��
			
			visited[now] = true; // �湮ó��
			
			for(Node node : array.get(now)) {
				if(cost[node.index] > cost[now] + node.distance) {
					cost[node.index] = cost[now] + node.distance; // �Ÿ� �� ���� 
					pq.offer(new Node(node.index, cost[node.index]));
				}
			}
			
		}
	}
}
