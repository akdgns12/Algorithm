package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// BOJ 1593 ���尡��� ���� ���� / LCA �˰���
public class ���尡���������� { 
	// BOJ ���尡���������� // ���尡��� ���� ���� ã�� ���α׷�
	// LCA�˰��� �̿��ϸ� �ȴ�. but DFS�� ��Ʈ������ ����ؾ� �ϱ� ������ ��Ʈ��尡 �ʿ��ѵ�
	// �������� ��Ʈ��带 ���� �������� �ʱ� ������ �θ� ��常�� �����ϴ� �迭�� �ϳ� ����� ��Ʈ��带 ������� �Ѵ�.
	static int N;
	static int[] parent;
	static int a,b;
	static ArrayList<ArrayList<Integer>> list; // ��尣�� ���踦 ��Ÿ�� list
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ���̽� ����
		
		for(int tc = 0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine()); // ����� ��
			list = new ArrayList<ArrayList<Integer>>(); // list �ʱ�ȭ
			for(int i=0; i<=N; i++) { // Ʈ�� ����
				list.add(new ArrayList<Integer>());
			}
			
			parent = new int[N+1];
			
			// �־��� ����� Ʈ�� �����
			for(int i=0; i<N-1; i++) { // Ʈ�� ä���
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a; // b�� �θ�� a��� �ǹ�
				list.get(a).add(b);
			}
			
			// ���� ������ ���� �� ���
			 st = new StringTokenizer(br.readLine());
			  a = Integer.parseInt(st.nextToken());
			  b = Integer.parseInt(st.nextToken());
			 
			 int a_depth = get_depth(a);
			 int b_depth = get_depth(b);
			 
			 int same = solve(a, a_depth, b, b_depth);
			 System.out.println(same);
		} // end for��
		
		
	}
	public static int solve(int a, int a_depth, int b, int b_depth) {
		// ���� depth�� ������������ ���� �ø���
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		}
		else if(a_depth < b_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		} // ������� depth ���� ���ִ� �۾� ��
		
		// ���۾��� �ǹ��ϴ� �� = depth�� ���� ���·�
		// ������ ���̹Ƿ� a�� b�� �ּҰ��� ������ ������
		// ��� �ּҰ����������� �����ִ� �۾�
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		 // return a, return b �Ѵ� �Ȱ��� ���� ��������
		// a�� b�� ���� �� = �ּҰ����������� ������� ������
		return a;
	}
	
	public static int get_depth(int node) {
		int ret = 0;
		int cur = node;
		while(cur != 0) { // ��Ʈ��尡 �� ������
			ret++;
			cur = parent[cur];
		}
		return ret-1; // ���������� return���� �ش� ����� depth ����
	}
}	
