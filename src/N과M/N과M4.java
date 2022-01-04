package N��M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_15652
// ��Ʈ��ŷ
/*
 * 1. 1���� N������ �ڿ��� �� M���� �� ����
 * 2. �񳻸�����
 * 3. �ߺ��Ǵ� ���� �ɷ��� �Ѵ�.
 */
// �� �������� = �ߺ��� ������ 5 4 3 3 2 1�� �Է��� �������� �� result> 1 2 3 3 4 5�� ǥ���Ǵ� ��
// ���� ���� �Է��� ���������� �Ѵٸ� �ߺ��� ������ 3���� ���� ���� �Ұ�

public class N��M4 {
	
	static int N,M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		// �ʱ� at = 1, depth = 0;
		dfs(1,0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int at, int depth) {
		/*
		 * ���̰� �ִ� ������ ���
		 * ���̻� Ž���� �ڽĳ��� �����Ƿ� return ���ش�
		 */
		if(depth == M) {
			for(int i =0; i<M; i++) { // arr�̶�� �迭�� �����͸� 0���� ���������� val�̶�� ���� �����Ѵ�
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		/*
		 * ���̸� 1�� ������Ű�鼭 DFS�� 
		 * ���ȣ���Ѵ�
		 */
		for(int i=at; i<=N; i++	) {
			arr[depth]=i;
			dfs(i, depth+1);
		}
	}
}
/*
 * ex) N = 4 , M = 2
 * 1. i = at , i = 1 ~ i = N, i = 4
 * arr[0] = 1;
 * dfs(1, 0+1);
 * 
 * 2. i = 2, 
 * arr[1] = 2;
 * dfs(2, 1+1);
 * 
 * 2���� ��ġ�� depth�� M�� ���� 2���ȴ�.
 * 
 * 3. i = 3;
 * arr[2] = 3;
 * dfs(3, 2+1);
 * 
 * 4. i = 4;
 * arr[3] = 4;
 * dfs(4, 3+1);
*/