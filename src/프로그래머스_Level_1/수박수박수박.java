package ���α׷��ӽ�_Level_1;
/*
 * ���̰� n�̰�, "���ڼ��ڼ��ڼ�..."�� ���� ������ �����ϴ� ���ڿ��� �����ϴ� �Լ�
 * solution�� �ϼ��϶�.
 * ���� ��� n�� 4�̸� "���ڼ���"�� �����ϰ� 3�̶�� "���ڼ�"�� return
 * 
 */
public class ���ڼ��ڼ��� {
	public String solution(int n) {
		String answer = "";
		
		for(int i=1; i<=n; i++) {
			if(i%2==1) {
				answer += "��";
			}else
				answer += "��";
		}
		
		
		return answer;
	}
}
