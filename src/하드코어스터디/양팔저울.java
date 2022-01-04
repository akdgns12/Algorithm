package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �������� {
	//BOJ 2629 �������� / ��� 2
	// �ߵ��� ���Կ� Ȯ���� �������� ���԰� �־��� ��
	// �־��� �߸��� ����Ͽ� ������ ���Ը� Ȯ���� �� �ִ��� �Ǻ�
	static int chu; // ���� ����
	static int chuW[]; // ���� ����
	static int marble; // ���� ����
	static int marbleW[]; // ���� ����
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		chu = Integer.parseInt(br.readLine());
		for(int i=0; i<chu; i++) {
			st = new StringTokenizer(br.readLine());
			chuW[i] = Integer.parseInt(st.nextToken());
		}
		
		marble = Integer.parseInt(br.readLine());
		for(int i=0; i<marble; i++) {
			st = new StringTokenizer(br.readLine());
			marbleW[i] = Integer.parseInt(st.nextToken());
		}
		// ���� ���� 30, �� 1���� ���� 500 ���� �� �ִ� �ִ� ���� 15000
		// ������ �ִ� ���� 40,000
		dp = new boolean[chu+1][55001]; 
		
		dfs(0,0);
		
		for(int i=0; i<chu; i++) {
			if(dp[chu][marbleW[i]]) {
				System.out.println("Y");
				continue;
			}
			System.out.println("N");
		}
	}
	
	public static void dfs(int count, int weight) {
		if(dp[count][weight]) return;
		dp[count][weight] = true;
		
		if(count == chu) return;
		
		dfs(count+1, weight); // 1. �� �ϳ� �״���� ����
		dfs(count+1, weight + chuW[count]); // 2. ���� <-> �� + ���ο� ��
		dfs(count+1, Math.abs(weight - chuW[count])); // 3. ���� + ���ο� �� <-> ��
	}
}
