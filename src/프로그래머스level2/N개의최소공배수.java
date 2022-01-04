package ���α׷��ӽ�level2;
/*
 * n���� ������ ���� �迭 arr�� �־��� ��
 * n���� ������ �ּҰ������ ��ȯ
 * 
 */
// ��Ŭ���� ȣ���� 
public class N�����ּҰ���� {
	public static int gcd(int a, int b) {
		int x = Math.max(a,b);
		int y = Math.min(a,b);
		
		while(x % y !=0) {
			int r = x%y;
			x = y;
			y = r;
		}
		return y;
	}
	
	public int solution(int[] arr	) {
		//1.�迭�� ù�� ° ���� ����.
		int answer = arr[0];
		//2. �迭�� ���̰� 1�̸� �ݺ� x, �� �̻��� ���� �ε����� 1���� �ݺ�
		for(int i=1; i<arr.length; i++) {
			//3. �� ���� �ִ�����
			int gcd = gcd(answer,arr[i]);
			//4. �ΰ��� �ּҰ����
			answer = answer * arr[i]/gcd;
		}
		
		
		return answer;
	}
}
