package DFS_BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * [���� ���� ����]
 * ���� -> ���� or ����(�ǵ��� ���� but ������ ��Ű�� �Ⱦ���)
 * ���� �ƴ� ��� ���� -> ���� ��  �� ����.
 * ������ �ѹ��̶� ���� ����� ������ �ƴ� ����̴�.
 * 
 * [Ǯ�� ����]
 * 1. ������ �ƴ� ������� ������ ������.
 * 2. ������ �ƴ� ����� �����ִ� ��Ƽ�� �����Ͽ� �ش� ��Ƽ���� ���� ������ �ƴ� ������� ������ �߰��Ѵ�.
 * 3. �̹� ������ �ƴ� ����̰ų�, �̹� Ȯ���� ��Ƽ�� �������� �ʴ´�.
 * 
 * - ������ �ƴ� ������� ������ ������.
 *  ������ �ƴ� ������� ������ �Է� �������鼭  ����Ʈ�� ������ �־���.
 *  - ������ �ƴ� ����� �����ִ� ��Ƽ�� �����Ͽ� �ش� ��Ƽ������ ������ �ƴ� ������� ������ �߰��Ѵ�.
 *  BFSŽ���� ���. 
 *  ����, ť�� ������ �ƴ� ������� ������ ����ְ� �Ѹ� �Ѹ� �����ִ� ��Ƽ�� �������ش�.
 *  ������ ���� �������� ���� ��Ƽ �߿���, ���� ����� �����ִ� ��Ƽ�� ������ �־���.
 *  ���� �̹� ������ �˰� �ִ� ����� �߰��ϸ� �ٽ� �� ����� Ȯ������ �ʾƵ� �ǹǷ� ������ �𸣴� ������� ������ ť�� ��´�.
 *  ���� ����� �����ִ� ��Ƽ�� �����ߴٸ� �ش� ��Ƽ�� �� �̻� ����Ǽ� ���� �� ���� ��Ƽ�� �ǹǷ� ������� ����Ǿ� ���� �� �ִ� ��Ƽ�� ��������
 *  1�� �ٿ��ش�.
 *  
 *  - �̹� ������ �ƴ� ����̰ų�, �̹� Ȯ���� ��Ƽ�� �������� �ʴ´�.
 */
public class BOJ_������_BFSǮ�� {
	
	static ArrayList<Integer> truth = new ArrayList<>();
	static ArrayList<Integer>[] party;
	static int n,m;
	static int total_party;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // ��� ��
		m = sc.nextInt(); // ��Ƽ ��
		
		int t = sc.nextInt(); // ������ �ƴ� ����� ��
		for(int i=0; i<t; i++) {
			truth.add(sc.nextInt()); // ������ �ƴ� ����� ��ȣ list�� �߰�
		}
		
		party = new ArrayList[m];
		for(int i=0; i<m; i++) { // ��Ƽ ���� �Է¹ޱ� ����
			party[i] = new ArrayList<>();
			
			int num = sc.nextInt();
			for(int j=0; j<num; j++) { // ��Ƽ�� ���� ����� ��ȣ���� party list�� ����
				party[j].add(sc.nextInt());
			}
		}
		
		total_party = m; // ������ �ƴ� ����� ���Ե� ��Ƽ �ٿ������� ���̹Ƿ� �ʱ�� ��Ƽ �� ��ü
		find_truth(); //BFS ����
		System.out.println(total_party);
	}
	
	public static void find_truth() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] party_visited = new boolean[m]; // ��Ƽ �湮 ���θ� üũ�ϴ� bool �迭
		boolean[] people_visited = new boolean[n+1]; // �̹� ������ �˰��ִ� ��� ���� üũ�ϴ� bool �迭
		// ����, ť�� ������ �ƴ� ������� ������ ����ش�.
		for(int i=0; i<truth.size(); i++) {
			q.offer(truth.get(i));
			people_visited[truth.get(i)] = true;
		}
		
		// �Ѹ� �Ѹ� �����ִ� ��Ƽ�� �����Ѵ�.
		while(!q.isEmpty()) {
			int current = q.poll(); // ������
			
			for(int i=0; i<m; i++) {
				// ������ ���� �������� ���� ��Ƽ �߿���, ���� ����� �����ִ� ��Ƽ�� �������ش�.
				if(!party_visited[i] && party[i].contains(Integer.valueOf(current))) {
					for(int j=0; j<party[i].size(); i++) {
						// ���� ������ �˰��ִ� ����� �߰��ϸ� �ٽ� �� ����� Ȯ������ �ʾƵ� �ǹǷ� 
						// ������ �𸣴� ������� ������ ť�� ����ش�.
						int next = party[i].get(j);
						if(!people_visited[next]) {
							people_visited[next] = true;
							q.offer(next);
						}
					}
					
					// ���� ����� �����ִ� ��Ƽ�� �����ߴٸ� �ش� ��Ƽ�� �� �̻� ����Ǽ�
					// ���� �� ���� ��Ƽ�� �ǹǷ� ������� ����Ǿ� ���� �� �ִ� ��Ƽ�� ��������
					// 1�� �ٿ��ش�.
					total_party--;
					party_visited[i] = true;
				}
			}
		}
	}
}
