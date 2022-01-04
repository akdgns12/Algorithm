package �׷���Ž��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ������ {
	// BOJ ������ / ��� 4 / �׷��� Ž�� / ������ �� �� �ִ� ��Ƽ�� �ִ� ����
	/*
	 * ������ ������ �����غ���
	 * ���� -> ���� or ����(�ǵ��� ���� but �������� ��Ű�� �Ⱦ���)
	 * ���� �ƴ� ��� ���� - > ���� �� �� ����
	 * ������ �� ���̶� ���� ����� ������ �ƴ� ���
	 * 
	 * Ǯ�� ����
	 * 1. ������ �ƴ� ������� ������ ������
	 * 2. ������ �ƴ� ����� �����ִ� ��Ƽ�� �����Ͽ� �ش� ��Ƽ������ ���� ������ �ƴ� ������� ������ �߰��Ѵ�.
	 * 3. �̹� ������ �ƴ� ����̰ų�, �̹� Ȯ���� ��Ƽ�� �������� �ʴ´�.
	 * 
	 * <������ �ƴ� ������� ������ ������>
	 *  - ������ �ƴ� ������� ������ �Է� �������鼭 ����Ʈ�� ������ �ش�
	 *  
	 *  <������ �ƴ� ����� �����ִ� ��Ƽ�� �����Ͽ� �ش� ��Ƽ������ ������ �ƴ� ������� ������ �߰��Ѵ�>
	 *  - BFSŽ���� ���. �������İ� ���. 
	 *  - ���� ť�� ������ �ƴ� ������� ������ ����ְ� �Ѹ� �Ѹ� �� �����ִ� ��Ƽ�� �������ش�.
	 *  - ������ ���� �������� ���� ��Ƽ �߿���, ���� ����� �����ִ� ��Ƽ�� ����
	 *  - ���� �̹� ������ �˰� �ִ� ����� �߰��ϸ� �ٽ� �� ����� Ȯ������ �ʾƵ� �ǹǷ�
	 *  ������ �𸣴� ������� ������ ť�� ����ش�.
	 *  - ���� ����� �����ִ� ��Ƽ�� �����ߴٸ� �ش� ��Ƽ�� �� �̻� ����Ǽ� ���� �� ����
	 *  ��Ƽ�� �ǹǷ� ������� ����Ǿ� ����  �� �ִ� ��Ƽ�� �������� 1�� �ٿ��ش�.
	 *  
	 *  <�̹� ������ �ƴ� ����̰ų�, �̹� Ȯ���� ��Ƽ�� �������� �ʴ´�>
	 *  - ��Ƽ �湮 ���θ� üũ�ϴ� boolean�迭��, �̹� ������ �˰� �ִ� ������θ� üũ�ϴ�
	 *  boolean �迭�� ���
	 */
	static int N,M;
	static int total_party;
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // ��� ��
		M = sc.nextInt(); // ��Ƽ ��
		
		int t = sc.nextInt(); // ������ �ƴ� ����� ��
		for(int i=0; i<t; i++) { // ������ �ƴ� ����� ��ȣ truth ����Ʈ�� ���
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
		find_truth();
		System.out.println(total_party);
	}
	
	public static void find_truth() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] party_visited = new boolean[M];
		boolean[] people_visited = new boolean[N+1];
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<M; i++) {
				if(!party_visited[i] && party[i].contains(Integer.valueOf(cur))) {
					for(int j=0; j<party[i].size(); j++) {
						int next = party[i].get(j);
						if(!people_visited[next]) {
						people_visited[next] = true;
						q.offer(next);
						}
					}
					total_party--;
					party_visited[i] = true;
				}
			}
		}
	}
}
