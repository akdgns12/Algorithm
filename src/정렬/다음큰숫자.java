package ����;

public class ����ū���� {
	public int solution(int n) {
		int answer = 0;
		
		//n�� 2������ ��ȯ
		String str = Integer.toBinaryString(n);
		//n�� 1�� ��Ʈ�� ���� �����ϴ� ����
		int cnt = 0;
		//n�� 1�� ��Ʈ�� ���� ī����
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '1') cnt++;
		}
		//n+1���� �ݺ�
		for(int i=n+1; i<1000000; i++ ) {
			String temp = Integer.toBinaryString(i);
			int temp_cnt = 0;
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j) == '1') temp_cnt++;
			}
			
			if(temp_cnt == cnt) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}
}