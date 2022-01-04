package �����������繮��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ���尡���������� {
	static int N; // ��� ����
	static ArrayList<ArrayList<Integer>> list; // ���� ���踦 ��Ÿ�� �׷��� list
	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// TC������ŭ ������
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<ArrayList<Integer>>(); // list �ʱ�ȭ
			// list ����
			for(int i=1; i<=N; i++) {
				list.add(new ArrayList<>());
			}
			
			// �־��� ����� Ʈ�� �����
			for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			parent[b] = a; // b�� �θ� a��� ��
				list.get(a).add(b);
			}
		
		
		// �������� ã������ ���
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int a_depth = get_depth(a);
		int b_depth = get_depth(b);
		
		int same = solve(a, a_depth, b, b_depth);
		System.out.println(same);
		}
		
	}
	
	public static int solve(int a, int a_depth, int b, int b_depth) {
		if(a_depth > b_depth) {
			while(a_depth != b_depth) {
				a_depth--;
				a = parent[a];
			}
		}
		if(b_depth > a_depth) {
			while(a_depth != b_depth) {
				b_depth--;
				b = parent[b];
			}
		}
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	
	public static int get_depth(int node) {
		int depth = 0;
		int cur = node;
		while(cur != 0) {
			depth++;
			cur = parent[cur];
		}
		return depth-1;
	}
}
