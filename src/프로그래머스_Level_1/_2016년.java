package ���α׷��ӽ�_Level_1;
/*
 * �� �� a,b�� �Է¹޾� 2016�� ������������ �����ϴ� �Լ� solution
 * ������ �̸��� �Ͽ��Ϻ��� ����ϱ��� SUN,MON,TUE,WED,THU,FRI,SAT
 * 2016���� ����
 */
// ���� = 4�⿡ �ѹ� �� 2.29���� �ִ� �ط� 366��
public class _2016�� {
	public String solution(int a, int b) {
		String answer = "";
		int total = 0;
		String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int[] m = {31,29,31,30,31,30,31,31,30,31,30,31};
		for(int i=0; i<a-1; i++) {
			total += m[i];
		}
		
		total += b-1;
		answer = day[total%7];
		return answer;
	}
}
