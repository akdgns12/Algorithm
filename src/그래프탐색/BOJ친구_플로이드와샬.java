package �׷���Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//
public class BOJģ��_�÷��̵�ͼ� {
	// BOJ ģ�� �ǹ� 1 / �׷��� Ž�� /
	/*
	 * A�� B�� ģ����, B�� A�� ģ���̰�, A�� A�� ģ���� �ƴϴ�.
	 * 2- ģ���� �Ǵ� ����
	 * 1. �� ����� ģ��
	 * 2. A�� ģ���̰� B�� ģ���� C�� �־�� �Ѵ�.
	 */
	
	/*
	 * [�÷��̵� �ͼ�]
	 * A,B,C,D,E�� �ִٰ� ���� ��  A�� B�� ģ���̰�, B�� C�� ģ���̸�
	 * A�� C�� ģ��.�׷� C�� D�� ģ���� �� A�� D�� ģ��? No, 2-ģ���̹Ƿ�
	 * ģ���� ģ�������� ģ��. ���� D�� A�� 3-ģ��. �� ���������� 2-ģ����
	 * ���ϹǷ� �÷��̵� �ͼ� �����ؼ� �� ģ������ n-ģ������ ���ϰ� 2������
	 * ģ������ ������ ���ϸ� �ȴ�.(0�� ���� ģ���� �ƴϹǷ� pass, 1�� 2�϶���
	 * ī��Ʈ �����ϸ� �ȴ�.)
	 */
	static int N;
	static final int INF = (int)1e9;
	static int[][] cost = new int[51][51];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			char[] str = br.readLine().toCharArray();
			for(int j=1; j<=N; j++) {
				if(i == j) continue;
				
				cost[i][j] = str[j-1] == 'Y' ? 1 : INF;
			}
		}
		
		// �÷��̵� �ͼ�
		for(int k=1; k<=N; k++) { // ���İ��� ��� K
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i == j) continue;
					
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);					
				}
			}
		} // end �÷��̵�

		int max = 0;
		for(int i=1; i<=N; i++) {
			int cnt = 0;
			
			for(int j=1; j<=N; j++) {
				if(cost[i][j] == 1 || cost[i][j] == 2) cnt++;
				
				max = Math.max(max, cnt);
			}
		} 
		
		System.out.println(max);
		
	}
}
