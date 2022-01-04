package N��M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N�� M (1)
// ��Ʈ��ŷ
// �ߺ��Ǵ� ���� ������ ��� ����� ����  Ž���ϸ� ��. �⺻������ ���
// ��͸� �ϸ鼭 �̹� �湮�� ���(��)�̶�� ���� ��带 Ž���ϱ� ����(������ ������� �˻��ϱ� ����)
// M ũ���� boolean �迭�� �����ϰ�, Ž���������� ���� ���� int �迭 arr�� �����Ѵ�.
// dfs �Լ����� N�� M�� ������ �ް� depth ������ �߰��ؾ��Ѵ�. depth�� ���� ��Ͱ� ����� ������ 
// depth�� 1�� �������� M�� �������� ���̻� ��͸� ȣ������ �ʰ� Ž������ �� ���� ��Ҵ� arr�迭�� ������ְ�
// return�ϴ� ������ ���ؼ�.

public class BOJ_15649 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �������� N�� M�� �ʱ�ȭ.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		
		// ���������� ���� �Ǳ� ������ ���� N�� M�� �Ѱ��� �ʿ� ����
		dfs(0);
		System.out.println(sb);
	}
	
		public static void dfs(int depth) {
			
			// ��� ���̰� M�� �������� Ž���������� ��Ҵ� �迭�� ���
			if (depth == M ) {
				for(int val : arr) {
					sb.append(val).append(' ');
				}
				sb.append("\n");
				return;
		}
			
			for(int i=0; i<N; i++) {
				// ���� �ش� ���(��)�� �湮���� �ʾҴٸ�?
				if(!visit[i]) {
					
					visit[i]=true; 	//�ش��带 �湮�� ���·� ����
					arr[depth]= i+1;	// �ش� ���̸� index�� �Ͽ� i+1�� ����
					dfs(depth +1);	// ���� �ڽ� ��� �湮�� ���� depth 1 ������Ű�鼭 ���ȣ��
					
					// �ڽĳ�� �湮�� ������ ���ƿ��� �湮��带  �湮���� ���� ���·� ����
					visit[i]= false;
				}
			}
	}
}

/*
boolean[] visit = new boolean[N];
int[] arr = new int[M];
 
public static void dfs(int N, int M, int depth) {
 
	// ��� ���̰� M�� �������� Ž���������� ��Ҵ� �迭�� ���
	if (depth == M) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
		return;
	}
 
 
	for (int i = 0; i < N; i++) {
 
		// ���� �ش� ���(��)�� �湮���� �ʾҴٸ�?
		if (visit[i] == false) {
			
			visit[i] = true;		// �ش� ��带 �湮���·� ����
			arr[depth] = i + 1;		// �ش� ���̸� index�� �Ͽ� i + 1 �� ����
			dfs(N, M, depth + 1);	// ���� �ڽ� ��� �湮�� ���� depth 1 ������Ű�鼭 ���ȣ��
            
			// �ڽĳ�� �湮�� ������ ���ƿ��� �湮��带 �湮���� ���� ���·� ����
			visit[i] = false;
		}
	}
	return;
}
*/