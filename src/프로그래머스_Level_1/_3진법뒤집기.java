package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;

/*
 * �ڿ��� n�� �Ű�����
 * n�� 3���� �󿡼� �յڷ� ������ ��, �̸� �ٽ� 10�������� ǥ���� ���� return
 */
public class _3���������� {
	public int solution(int n) {
		int answer = 0;
		ArrayList<Integer> temp =new ArrayList<>();
		
		//10���� -> 3����(����)
		while(true) {
			if(n<3) {
				temp.add(n); 
				break;
			}
			temp.add(n%3);
			n = n/3;
		}
		//3����(����) -> 10����
		int x = 1;
		for(int i=temp.size()-1; i>=0; i--) {
			answer += temp.get(i)*x;
			x *= 3;
		}
		
		return answer;
		
	}
}
