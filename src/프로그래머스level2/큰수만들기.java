package ���α׷��ӽ�level2;

/*
 * <�˰���>
 * ���� �����ؾ��ϴ� ���� 4�ڸ��� �����, �Է°����� �� ���� 3�ڸ��� ������
 * ���ڿ� �κп��� ���� ū ���� ã�´�. �׸����� ū ���� ã�� �ڸ� ���ĺ���
 * ������ 2�ڸ��� ������ ������ ū���� ã�´�. �� ������ �ݺ�
 * ex) 5678543 => 5,6,7,8 �� ���� ū �� 8
 */
public class ū������� {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
		int idx = 0;
		char max;
		if(number.charAt(0)== '0')	return "0";
		for(int i=0; i<number.length()-k; i++) { // number���� k�ڸ���ŭ �A ��������
			max = '0';
			//j�� ������ idx�� ���� ������ �̹� ������ �ִ��� ����ġ�� ���ؼ�
			for(int j=idx; j<=i+k; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j+1;
				}
			}
			answer.append(max);
		}
		
		return answer.toString();
	}
}
