package �����ڵ�;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// ù° �ٿ�  �ּ�ȯ�� Ƚ���� ����Ѵ�. �Ұ����� ��쿡�� -1 ���

// ���ͽ�Ʈ�� �˰���

public class �ּ�ȯ�¹���_BOJ_2021 {
	static class Node implements Comparable<Node>{ // �켱���� ť�� �����Ͱ� �� ������ distance�� �� ���� ���� �켱������ ������ Comparable Ŭ���� ����
		int index;
		int distance;
		
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public int getDistance() {
			return this.distance;
		}
		
		// �Ÿ��� ª�� ���� ���� �켱������ �������� ����
		@Override
		public int compareTo(Node o) {
			if(this.distance < o.distance) {
				return -1;
			}
			return 1;
		}
	} // Node
	
	static int N, L; // N ���� ����, L �뼱�� ����
	static final int INF = (int)1e9;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] d = new int[100001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		// �׷��� �ʱ�ȭ
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
	}

}
