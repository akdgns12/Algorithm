package ���α׷��ӽ�_Level_1;
/*
 * ���� num�� ¦���� ��� "Even"�� ��ȯ�ϰ�
 * Ȧ���� ��� "Odd"�� ��ȯ�ϴ� �Լ�
 * solution
 * 
 */
public class ¦����Ȧ�� {
		public String solution(int num) {
			String answer = "";
			
			if(num % 2 == 0) {
				answer = "Even";
			}else 
				answer = "Odd";
			
			return answer;
		}
}
