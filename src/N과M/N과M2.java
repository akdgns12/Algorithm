package N��M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ_15650
// 1���� N������ �� �� ���������̸鼭 M�� ���̱��� ���� ������ ����

public class N��M2 {
	
	static int N, M;
	//static boolean[] visit; (1)�� �޸� �ߺ��湮������ ����� �ʿ䰡 ������ boolean �迭�� �ߺ����θ� üũ�� �ʿ� x
	// ��Ͱ������� ���� ��� �迭�� ä���� ���ϴ� ��쿡�� depth == M �� �� �� ���Եǰ�, �ݺ����� ���� ������ ������ �ڵ����� �ɷ����� �ȴ�.
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		dfs(1, 0);
		System.out.println(sb);
		
	}
	
	/*
	 * at������ �ǹ̴� ���� ��ġ, �� ��𼭺��� �����ϴ����� �ǹ��ϴ� ����.
	 * ���ε�� �ݺ������� ��͸� ���� ��, at=1���� �����ϸ� ���� ��ʹ� ������������ Ž���ϱ� ���� at�� 1������Ų 2��
	 * ���ڷ� �Ѱ��ָ鼭 ���� ����� �ݺ����� 2���� �������� �ϴ� ������ �ǹ��Ѵ�.
	 */
	public static void dfs(int at, int depth) {
			/*
			 ���̰� M�̶� ������� ���
			 */
			if(depth==M) {
				for(int val : arr) { // arr�̶�� �迭�� �����͸� 0���� ���������� val�̶�� ���� ���Եȴ�.
					sb.append(val).append(' ');
				}
				sb.append('\n');
				return;
			}
			/*
			 * ����ϸ鼭 ��Ʈ��ŷ �� 
			 * �ݺ��� ����
			 */
			for(int i=at; i<=N; i++) {
				arr[depth]=i;
				dfs(i+1, depth+1);
			}
		}
	}