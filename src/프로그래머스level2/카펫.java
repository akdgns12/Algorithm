package ���α׷��ӽ�level2;
/*
 * leo�� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� 
 * ũ��� ������� ����.
 */
// ���� ������ �� brown, ����� ������ �� yellow
// ī���� ����,���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution
public class ī�� {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};
		int x,y = 0; // ���� ����
		int sum = (brown + 4) / 2;
		
		for( y = 3; y<=sum; y++) {
			x = sum - y;
			if(x<y) break;
			
			if((x-2) * (y-2) == yellow) {
				answer[0] = x;
				answer[1] = y;
				break;
			}
		}
		
		return answer;
	}
}
