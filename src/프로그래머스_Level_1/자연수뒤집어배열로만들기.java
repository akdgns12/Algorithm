package ���α׷��ӽ�_Level_1;
/*
 * �ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� return
 * ���� ��� n�� 12345�̸� [5,4,3,2,1]dmf return
 */
public class �ڿ���������迭�θ���� {
	public int[] solution(long n) {
		String a = "" + n;
		int[] answer = new int[a.length()];
		int cnt = 0;
		while(n !=0 ) {
			answer[cnt]= (int)(n%10);
			n /= 10;
			cnt++;
		}
		return answer;
	}
}
