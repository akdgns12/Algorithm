package ���α׷��ӽ�level2;

public class _124�����Ǽ��� {
	public String solution(int n) {
		String answer = "";
		String[] str = { "4", "1", "2"};
		
		while(n>0) {
			// 1.���� �������� ���� �ش簪�� ���ڿ��� ����
			
			answer = str[n%3] + answer;
			//2. 3�� ����� ���� (n-1)/3 , �ƴ� ���� �׳� n/3
			n = n%3 == 0 ? (n-1)/3 : n/3;
		}
		
		
		
		return answer;
	}
}
