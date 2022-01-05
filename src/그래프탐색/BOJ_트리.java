package �׷���Ž��;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * <Ǯ��>
 * �θ� �ε����� �Է¹ް� , ��带 ������ �� ���� ��带 count�ϴ� ������ 
 * dfs�����Ͽ� ���� Ǯ��
 * ��带 ������ ���� ����Լ��� �̿��Ͽ� ���� ����� �θ� �ε����� ������ �����
 * ���������� ������ �Ͼ���� �����Ѵ�.
 * ������带 ī��Ʈ �� ������ dfs�� Ȱ���Ͽ� ���� ��带 �θ�� ������ ��尡
 * �ϳ��� �����Ѵٸ� �ڽĳ�带 ���������� Ž���ϵ��� �Ͽ���. ��� �Լ� ��
 * ���� �ڽĳ�尡 �ϳ��� �����ϴ����� ����� �ֱ� ���� booleanŸ���� ������
 * �ϳ� �������ش�. �ڽ� ��尡 ���ٸ� ��������� ī��Ʈ�� ������Ų��.
 */
public class BOJ_Ʈ�� {
	static int n, delete;
	static int[] parent;
	static int count;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����� ���� n
		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		int root = 0;
		
		//�� ����� �θ� ���� �ޱ�
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if(parent[i] == -1) root = i;
		}
		
		//�����ϴ� ���
		delete = Integer.parseInt(br.readLine());
		
		deleteNode(delete);
		
		count = 0;
		visited = new boolean[n];
		countLeaf(root);
		
		System.out.println(count);		
	}
	
	public static void deleteNode(int d) {
		parent[d] = -2; // ������ ��� -2�� ǥ��
		for(int i=0; i<n; i++) {
			if(parent[i] == d) {
				deleteNode(i);
			}
		}
	}
	
	public static void countLeaf(int s) {
		boolean isLeaf = true;
		visited[s] = true;
		if(parent[s] != -2) {
			for(int i=0; i<n; i++) {
				if(parent[i] == s && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if(isLeaf) count++;
		}
	}
	
}
