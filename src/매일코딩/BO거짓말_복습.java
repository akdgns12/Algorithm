package �����ڵ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BO������_���� {
	// 1. ������ �ƴ� ������� ������ list�� ��´�
	// 2. ������ �ƴ� ������� ��Ƽ�� �����Ͽ� �ش� ��Ƽ������ 
	//    ��� ������ �ƴ� ������� ���� list�� �߰��Ѵ�
	// 3. �̹� ������ �˰� �ִ� ����̰ų�, �̹� Ȯ���� ��Ƽ�� �������� �ʴ´�.
	
	static int N, M;
	// ������ �˰� �ִ� ������� ��ȣ ���� list
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party; // �� ��Ƽ ���� ���� list�迭
	static int total_party;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int T = sc.nextInt(); // ������ �˰� �ִ� ��� ��
		for(int i=0; i<T; i++) { // ������ �˰� �ִ� ��� ��ȣ list�� �־���
			truth.add(sc.nextInt());
		}
		
		party = new ArrayList[M];
		for(int i=0; i<M; i++) {
			party[i] = new ArrayList<>();
			
			int num = sc.nextInt();
			for(int j=0; j<num; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		total_party = M;
		bfs();
		System.out.println(total_party);
		
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] people_visited = new boolean[N+1]; // �˻��� ��� üũ�� �迭
		boolean[] party_visited = new boolean[M]; // �˻��� ��Ƽ üũ�� �迭
		// ������ �˰� �ִ� ����� �� ť�� �־��ֱ�
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<M; i++) {
				if(!party_visited[i] && party[i].contains(Integer.valueOf(cur))) {
					for(int j=0; j<party[i].size(); j++){
						int next = party[i].get(j);
						if(!people_visited[next]) {
							people_visited[next] = true;
							q.offer(next);
						}
					}
					total_party--;
					party_visited[i] = true;
				}
			} // end For
		} // end While
	}
}
