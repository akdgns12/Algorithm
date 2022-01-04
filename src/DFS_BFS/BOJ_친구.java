package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * [�÷��̵� �ͼ�]
 * A, B, C, D, E�� �ִٰ� ����. A�� B�� ģ���̰�, B�� C�� ģ���� �� 
 * A�� C�� ģ���̴�. �׷� C�� D�� ģ���� �� A�� D�� ģ���ϱ�? �ƴϴ�. 2-ģ���̹Ƿ�
 * ���� ģ���� ģ������ �����ȴ�. ���� D�� A�� 3-ģ���̴�. �� ���������� 2-ģ������
 * ������ ���ϹǷ� �÷��̵� �ͼ��� �����Ͽ� �� ģ������ n-ģ������ ���ϰ� 2������ ģ������
 * ������ ���ϵ��� �Ѵ�.(0�ϋ��� ģ���� �ƴϹǷ� pass, 1�� 2�� ���� ī��Ʈ�� �����Ѵ�)
 */
public class BOJ_ģ�� {
	//���� ������ ����� 2-ģ���� ���� ���϶�
	// � ��� A�� �Ǵٸ� ��� B�� 2-ģ���� �Ǳ� ���ؼ�, �� ����� ģ���̰ų�,
	// A�� ģ���̰�, B�� ģ���� C�� �����ؾ��Ѵ�.
	
	// ��� �������� �ٸ� ��� ���������� ���ؾ� �ϱ� ������ �÷��̵� �ͼ� �˰���
	static int N;
	static int MAX_VALUE = 987654321;
	static int[][] friends; //2���� ���̺� <- ���⿡ �ִܰŸ� ������ ����
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		friends = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j) == 'N') // ģ���� �ƴ� ��� MAX_VALUE
					friends[i][j] = MAX_VALUE;
				else // ģ���� ��� 1
					friends[i][j] = 1;
				if(i == j) // �ڱ� �ڽŰ��� �Ÿ��� 0���� ����
					friends[i][j] = 0;
			}
		}
		
		// �÷��̵� �ͼ� �˰��� ����
		// k : ��������
		// i : ����
		// j : ����
		// i -> j�� ���� ��κ��� i ->  k -> j�� ���� ��ΰ� ª���� ���� �����Ѵ�
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(friends[i][j] > friends[i][k] + friends[k][j])
						friends[i][j] = friends[i][k] + friends[k][j];
				}
			}
		}
		
		
		int max = 0;
		for(int i=0; i<N; i++) {
			int count = 0;
			//2-ģ���� ���� ���Ѵ�	
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(friends[i][j] <= 2) count++;
			}
			if(max < count) max = count;
		}
		System.out.println(max);

	}
}
