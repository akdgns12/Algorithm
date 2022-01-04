package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_������ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, total = 0;
	static boolean[] truePeople = new boolean[51];
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ��� ��
		M = Integer.parseInt(st.nextToken()); // ��Ƽ ��
		
		// 1. union-find �ʱ�ȭ
		parent = new int[N+1];
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		// 2. ������ �ƴ� ��� ���� �޾ƿ��� truePeople[������ �ƴ»��] = true
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // �ι�° �� = ������ �ƴ� ����� ��
		for(int i=0; i<n; i++) {
			truePeople[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 3. ��Ƽ ������ �޾ƿ��鼭 ���� ��Ƽ�� �ִ� ����� union
		ArrayList<Integer>[] peoples = new ArrayList[M];
		for(int i=0; i<M; i++) {
			peoples[i] = new ArrayList<>();
		}
		
		int value, pre = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n > 0) {
				pre = Integer.parseInt(st.nextToken());
				peoples[i].add(pre);
			}
			for(int j=1; j<n; j++) {
				value = Integer.parseInt(st.nextToken());
				peoples[i].add(value);
				union(pre, value); // �θ� union�ϸ� ��ΰ� ���� parent�� ���� ��.
				pre = value;
			}
		}
		
		// 4. ������ �ƴ� ������� parent�� ���� ��Ƽ�� ���� �����Ƿ� ������ �ƴ� �����
		int parent;
		for(int i=1; i<truePeople.length; i++) {
			if(truePeople[i]) {
				truePeople[find(i)] = true;
			}
		}
		
		// 5. ������ �ƴ� ������ ��Ƽ�� �������� �ʾ����� total++
		for(int i=0; i<M; i++) {
			if(peoples[i].size() > 0) {
				parent = find(peoples[i].get(0));
				if(!truePeople[parent]) total++;
			}
		}
		
		// 6. ������ �� �� �ִ� ��Ƽ �ִ� �� ���
		private static int find(int x) {
			if(parent[x] == x)
				return parent[x] = x;
			else return find(parent[x]);
		}
		
		private static boolean union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if(a!=b) {
				if(a > b) {
					parent[a] = b;
				}else {
					parent[b] = a;
				}
				return true;
			}
			return false;
		}
	}
