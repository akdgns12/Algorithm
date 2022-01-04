package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;

public class �ù���_���ͽ�Ʈ�󺹽� {
	static int N,M;
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[50001];
	static int start = 1;
	
	public static void main(String[] args) throws IOException{
		/*
		 * ���� -> ��ȫ
		 * �ҵ鿡�� ������ ����Ѵ�
		 * N (�갣, ���)
		 * M(��, ����)
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//�׷��� �ʱ�ȭ
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//�ִܰŸ� ���̺� �ִ�� �ʱ�ȭ
		Arrays.fill(d, INF);
		
		//���ͽ�Ʈ�� �˰��� ����
		dijkstra();
		
		System.out.println();
		
		
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//���� ������ 1
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance(); // ���� �������� �Ÿ�
			int now = node.getIndex(); // ���� ���
			
			if(d[now] < dist) {
				continue;
			}
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	} //dijkstra
	
	static class Node implements Comparable<Node> {
		private int index;
		private int distance;
		
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
		
		private int getIndex() {
			return this.index;
		}
		
		private int getDistance() {
			return this.distance;
		}
		
		@Override
		public int compareTo(Node other) {
			if(this.distance < other.distance) {
				return  -1;
			}
			return 1;
		}
	} // Node
}
