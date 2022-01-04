package �����ڵ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * ����ġ ���� ���� �׷��� G�� �־����� ��, ��� ����(i,j)�� ���ؼ�, i���� j�� ����
 * ��ΰ� �ִ��� ������ ���ϴ� ���α׷��� �ۼ��϶�
 * 
 * �Է� 
 * ù°�ٿ� ������ ���� N(1~100)�� �־�����. ��°�ٺ��� N�� �ٿ��� �׷����� ��������� �־�����.
 * i���� ���� j��° ���ڰ� 1�� ��쿡�� i���� j�� ���� ������ �����Ѵٴ� ���̰�,
 * 0�� ���� ���ٴ� ���̴�. i��° ���� i��° ���ڴ� �׻� 0�̴�.
 */

// �÷��̵� �ͼ� �˰���
/*
 * ��� �������� ��� ���������� �ִܰŸ��� ���ϴ� �˰���.
 * ���ͽ�Ʈ�� �˰����̳� ���� ���� �˰����� �� �������� �ٸ� ��� ������ �ִܰŸ��� ���ϴ� �Ͱ� ���̰� �ִ�.
 * 
 * �÷��̵� �ͼ� �˰����� �ٽ� ���̵��� '���İ��� ����'�� �������� �Ѵٴ� ��
 * ��, i���� j���� ���� �Ͱ� i���� k�� ����, k���� j�� ���� ���� ���ٴ� �ǹ��Դϴ�.
 * 
 * �̷��� ���̵��� ������ ���ǰ� ������ �����ؾ� �Ѵ�. ���������� i���� j�� �� �� �ִ� ��ΰ� �ִ��� �Ǵ��ؾ� �ϱ� �����̴�.
 * 
 * ����, ���İ��� ������ k�� 0�� ��, 1�� ��, ... , N - 1�϶����� �����س���,
 * arr[i][k] == 1 && arr[k][j] == 1 �� ��츸 arr[i][j] == 1 �� �ʱ�ȭ �ϸ� �ȴ�.
 */
public class _�÷��̵�ͼ���������_���ذ��ã�� {
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i���� j���� �� �� �ִ°�?
		// i���� k�� ����, k���� j�� �� �� �ִ°�?
		// ���� 2���� ������ ������
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					// �ܼ��� �� �� �ִ� ��ΰ� �ִ����� üũ��
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
