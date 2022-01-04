package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ��Ȧ {
	// BOJ 1865 / ��Ȧ / �� 3 / ��������˰���
	/*
	 * ������ ���� - �������� �˰���
	 */
	// �������� ��Ȧ�� �پ��� �ð��� �ǹ��ϹǷ� -> ���� ����ġ�� �ǹ�
	/*
	 * 	�������� �ִܰ�� �˰��� ���۰���
 * 1. ��� ��带 �����մϴ�.
 * 2. �ִ� �Ÿ� ���̺��� �ʱ�ȭ�մϴ�.(�ٸ� ��� ��忡 ���ؼ� �Ÿ��� �������� �ʱ�ȭ)
 * 3. ������ ������ N-1�� �ݺ��մϴ�.
 *    1. ��ü ���� E���� �ϳ��� Ȯ���մϴ�.
 *    2. �� ������ ���� �ٸ� ���� ���� ����� ����Ͽ� �ִ� �Ÿ� ���̺��� �����մϴ�.
 *  ���� '���� ���� ��ȯ�� �߻��ϴ��� üũ�ϰ� �ʹٸ�' 3���� ������ �ѹ� �� �����մϴ�.
 *   �̶� �ִ� �Ÿ� ���̺��� ���ŵȴٸ� ���� ���� ��ȯ�� �����ϴ� ��.
 *   
 *   �������� �˰��� vs ���ͽ�Ʈ�� �˰���
 *   
 *   - ���ͽ�Ʈ�� �˰��� 
 *     - '�Ź� �湮���� ���� ��� �߿��� �ִ� �Ÿ��� ���� ª�� ��带 ����'
 *     - ���� ������ ���ٸ� ������ �ظ� ã�� �� �ִ�.
 *   - �������� �˰���
 *     - '�Ź� ��� ������ ���� Ȯ��'
 *       - ���� "���ͽ�Ʈ�� �˰��򿡼��� ������ �ظ� �׻� ����"
 *     - ���ͽ�Ʈ�� �˰��� ���ؼ� �ð��� ���� �ɸ����� ���� ���� ��ȯ�� Ž���� �� �ִ�.
	 */
	// ������ �����ڸ� �� N���� ��尡 �ְ� M���� ������ �ִٸ�, |N-1|�� M���� ������ ���� dist[]�� �������ְ�
	// 1�� M���� ������ ���� dist[]�� �����Ϸ��� �� �� ������ �ȴٸ� ���� ����Ŭ�� �ִ°�.
	static class Node{
		int start, end, cost;
		
		public Node(int start, int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	static int TC;
	static int N,M,W;
	static final int INF = (int)1e9;
	static int[] dist; 
	static ArrayList<Node> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		 
		TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // ������ �� - ����� ��
			M = Integer.parseInt(st.nextToken()); // ������ �� - ������ �� 
			W = Integer.parseInt(st.nextToken()); // ��Ȧ ����
			
			graph = new ArrayList<>();
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				// ���δ� ����� �׷���
				graph.add(new Node(start, end,cost));
				graph.add(new Node(end, start,cost));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				// ��Ȧ�� �ܹ��� �׷���
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.add(new Node(start, end,-cost));
			}
			
			
			if(bellmanFord())  // ���� ����Ŭ�� �ִ� ���
				System.out.println("YES");
			else  // ���� ����Ŭ�� ���� ���
				System.out.println("NO");
		} // end while
		
	}
	
	public static boolean bellmanFord() {
		dist[1] = 0; // �������� 1������ �����ϰ� 0���� �ʱ�ȭ
		
		// N-1��  M���� ������ ���� dist[]�� �������ش�.
		for(int i=1; i<N; i++) { // ���� �� ��忡��
			for(int j=0; j<graph.size(); j++) { //���� ������ŭ *������ �� : ���� ������ŭ ������� �ϴµ� ���������� �Է¹��� M���� �����ϸ� �ȵȴ�.
				// ��Ȧ ���� �׷����� �Ϻκ��̱� ������ graph.size()�� ������ ������ �ȴ�. ���������� ���� M��ŭ�� ���� ��Ȧ ���� �����ϴ� case�� �ȴ�.
				Node cur = graph.get(j);
				int start = cur.start;
				int end = cur.end;
				int cost = cur.cost;
				// ���� ������ ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(dist[start] != INF && dist[end] > dist[start] + cost) {
					dist[end] = dist[start] + cost;
				}
			}
		}
		
		//�� ������ ���� ���� ����Ŭ ���� Ȯ��
		for(int i=0; i<graph.size(); i++) {
			Node cur = graph.get(i);
			int start = cur.start;
			int end = cur.end;
			int cost = cur.cost;
			// ������ �� �� ���
			if(dist[start] != INF && dist[end] > dist[start] + cost) {
				return true;
			}
		}
		// ������ ���� ���� ���
		return false;
	}
}
