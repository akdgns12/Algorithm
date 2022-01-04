package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javax.xml.soap.Node;
//���ǻ���
/*
 * 1. ���ͽ�Ʈ�� �˰���
 * 2. �����
 */
public class �ù��� {
	static int n,m;
	static final int INF = (int) 1e9;
	// �� ��忡 ����Ǿ� �ִ� ��忡 ���� ������ ��� �迭
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int start = 1;
	// �ִ� �Ÿ� ���̺� �����
	static int[] d = new int[50001];
	
	public static void main(String[] args) throws IOException{
		// ���� -> ��ȫ
		// �߰��� �ҵ鿡�� ������ ����Ѵ�.
		// �ּ����� �Ҹ� ������ �ʹ�
		
		// N(�갣, ����)
		// M(��, ����)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// �׷��� �ʱ�ȭ
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// ����� ������ش�.
			graph.get(a).add(new Node(b,c)); // a -> b ���� ���� ��� c
			graph.get(b).add(new Node(a,c)); // b -> a ���� ���� ��� c
		}
		
		// �ִ� �Ÿ� ���̺��� ��� �������� �ʱ�ȭ
		Arrays.fill(d, INF);
		
		dijkstra();
		
		System.out.println(d[n]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//���� ������ 1 start = 1
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) { // ť�� ������� �ʴٸ�
			// ���� �ִ� �Ÿ��� ª�� ��忡 ���� ���� ������
			Node node = pq.poll();
			int dist = node.distance; // ���� �������� �Ÿ�
			int now = node.index; // ���� ���
			
			// ���� ��尡 �̹� ó���� ���� �ִ� ����� ����
			/*
			 * why ? -> �̹� �湮�ؼ� ��忡 ���� �Ÿ��� �ִܰŸ����̺� ���ŵ� ���¶��
			 *			�켱����ť���� ������ ��忡 ���� �Ÿ����� > ���� �ش� ����� �Ÿ�
			 *			�̱� ������ �湮ó�� �迭 ���� �������� �ʰ� ���� �� �ִ�.
			 */
			if(d[now] < dist) {
				continue;
			}
			
			// ���� ���� ����� �ٸ� ������ ������ Ȯ��
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				// ���� ��带 ���ļ�, �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{ // �켱���� ť�� �����Ͱ� �� �� distance�� �� ���� ���� ���� �켱������ ���� �� �ֵ��� �ϱ����� comparable Ŭ���� ���
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
		
		// �Ÿ�(���)�� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(Node o) {
			if(this.distance < o.distance) {
				return -1;
			}
			return 1;
		}
	} //Node
}
