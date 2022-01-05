package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class �������ǰŸ� {
	// BOJ 1240  �� 4 / �������� �Ÿ� / ����ġ�� �ִ� Ʈ���� Ž������ �⺻
	// class�� �̿��ؼ� ���� �湮�� ��ġ�� �Ÿ��� �Է��صΰ� Ž���ϸ鼭 �Ÿ��� ��� 
	// �����ָ� �ȴ�. Ž���� BFS
	// ������ �Է��� �� �������� �̵��� �����ϰԲ� ��������� ����Ʈ�� �־�����Ѵ�.
	static class Node{
		int next, dist;
	
		public Node(int next, int dist) {
			this.next = next;
			this.dist = dist;
		}
	}
	
	static int N, M;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ����� ����
		M = Integer.parseInt(st.nextToken()); // ������ �Ÿ��� �˰���� ��� �� ����
	
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			// ����� �������ش�.
			list[start].add(new Node(end, dist));
			list[end].add(new Node(start, dist));
		}
		
		// �Ÿ��� �˰���� ����� ��
		for(int j=0; j<M; j++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(find(start, end));
		}
	}
	
	public static int find(int start, int end) {
		visited = new boolean[N+1];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(start, 0));
		visited[start] = true;
		
		int dist = 0;
		while(!q.isEmpty()) {
			Node node = q.poll();
			if(node.next == end) {
				dist = node.dist;
				break;
			}
			
			for(Node temp : list[node.next]) {
				if(!visited[temp.next]) {
					q.offer(new Node(temp.next, node.dist + temp.dist));
					visited[temp.next] = true;  
				}
			}
		}
		return dist;
	}
}
