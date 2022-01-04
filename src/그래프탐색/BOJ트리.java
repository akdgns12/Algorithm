package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJƮ�� {
	static int N;
	static int root; // ��Ʈ ��带 ������ ����
	static int delete; // ������ ��� ��ȣ
	static int answer;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // Ʈ���� ��� ����
		
		tree = new ArrayList[N];
		for(int i=0; i<N; i++) { // Ʈ�� �ʱ� ����
			tree[i] = new ArrayList<>(); 
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken()); // �� ����� �θ�
			
			if(parent == -1 ) root = i; // �θ� ���ٸ� -1�� �־�����. �� ��Ʈ�̴�.
			else
				tree[parent].add(i); 
		}
		
		delete = Integer.parseInt(br.readLine());
		
		dfs(root); // ��Ʈ���� Ž��
		
		System.out.println(answer);
	}
	
	public static void dfs(int node) {
		if(node == delete) return; // ������ ����̸� Ž�� ����
		
		if(tree[node].size() == 0) {
			// �ڽ��� ���� -> ��������̴�.
			answer++;
			return;
		}
		
		for(int v : tree[node]) {
			if(v == delete && tree[node].size() == 1) {
				// ���� ��尡 ������ ��常�� �ڽ����� ������ �ִ�. -> ������尡 �ȴ�.
				answer++;
				return;
			}
			dfs(v);
		}
		
	}
}
