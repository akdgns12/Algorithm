package Greedy;

import java.util.Arrays;

public class �ܼ�ī�޶�_lv3 {
	public int solution(int[][] routes) {
		int answer = 0; //ī�޶��� ����
		int camera = -30001; //ī�޶� �ʱ� ��ġ
		
		//���������� �������� ������������ ����
		Arrays.sort(routes, (a,b) -> Integer.compare(a[1],  a[1]));
		
		//ī�޶���ġ�� ���������� �������� ���ĵ� ���� ���� ������ ��
		//ī�޶� ��ġ���� ���� ������ �� ũ�ٸ� ������ ����Ƿ�
		//ī�޶� �Ѵ� �÷��ְ� ī�޶� ��ġ�� ������ ������ ������ ��ġ.
		for(int[] route : routes) {
			if(camera < route[0]) {
				camera = route[1];
				answer++;
			}
		}
		
		
		
		
		
		
		
		return answer;
	}
}
