package �̺�Ž��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class �����⼳ġ {
	// BOJ_2110 / �����⼳ġ / �̺�Ž�� / �ǹ� 1
	static int N, M;
	static int house[];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new int[N];
		
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		// �̺�Ž�� �� ����
		Arrays.sort(house);
		// �������� �Ÿ��� �������� �̺�Ž��
		int start = 1; // ���� �� �ִ� �ּ� �Ÿ�
		int end = house[N-1] - house[0]; // ���� �� �ִ� �ִ�Ÿ�
		
		while(start < end) {
			int mid = (start + end) / 2;
			/*
			 * mid �Ÿ��� ���� ��ġ������ ������ ������ M������ ����ġ��
			 * �Ÿ��� ������ �ϱ� ������ hi�� ���δ�.
			 */
			if(callInstall(mid) < M) {
				end = mid;
			}
			else {
				/*
				 * ��ġ������ ������ ������ M�������� ũ�ų� ������
				 * �Ÿ��� �����鼭 �ּҰŸ��� ���� �� �ִ� �ִ�Ÿ���
				 * ã�Ƴ���.
				 */
				start = mid + 1;
			}
		}
		
		/*
		 * Upper Bound�� Ž������ �ʰ��ϴ� ù ��° ���� ����Ű�Ƿ�
		 * 1�� ���� ���� ���ǽ��� �����ϴ� �ִ��� ��.
		 */
		System.out.println(start - 1);
	}
	// distance�� ���� ��ġ ������ ������ ������ ã�� �޼ҵ�
	public static int callInstall(int distance) {
		// ù��° ���� ������ ��ġ�Ѵٰ� ����
		int count = 1;
		int lastLocate = house[0];
		
		for(int i=1; i<house.length; i++) {
			int locate = house[i];
			
			/*
			 * ���� Ž���ϴ� ���� ��ġ�� ��������ġ�ߴ� ���� ��ġ�� �Ÿ���
			 * �ּ� �Ÿ�(distance)���� ũ�ų� ���� �� ������ ��ġ������ �÷��ְ�
			 * ������ ��ġ ��ġ�� �������ش�.
			 */
			if(locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		return count;
	}
}
