package ���α׷��ӽ�_Level_1;
/*
 * String �迭 seoul�� element �� "Kim"�� ��ġ�� x
 * "�輭���� x�� �ִ�"�� String�� ��ȯ�ϴ� �Լ� solution
 * seoul�� "Kim"�� ���� �ѹ��� ��Ÿ���� �߸��� ���� �ԷµǴ� ���� ����.
 */
public class ���￡���輭��ã�� {
	public String solution(String[] seoul) {
		String answer ="";
		String Kim = "Kim";
		
		
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals(Kim)) {
				answer =  "�輭���� " + i + "�� �ִ�";
				break;
			}
		}
		
		return answer;
	}
}
