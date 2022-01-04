package ���α׷��ӽ�level2;

import java.util.Arrays;

/*
 * H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ.
 * ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ� �Ѵ�.
 * ��ǥ�� �� n�� ��, h�� �̻� �ο�� ���� h�� �̻��̰� ������ ����
 * h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index.
 * ���� �ο� Ƚ���� ���� �迭 citations
 * H-Index�� return�϶� 
 */
public class H_Index {
	public int solution(int[] citations) {
		int answer = 0;
		
		int len = citations.length;
		Arrays.sort(citations);
		int max = 0;
		int cnt = 0;
		
		for(int h=0; h<citations[len-1]; h++) {
			//�ο�Ƚ�� h���� ū �ο빮�� ���� ã��
			for(int j=0; j<len; j++) {
				if(h<=citations[j])
					cnt++;
			}
			//h���� ū �ο빮�� ������ h�̻��̸� max���� update
			if(cnt >=h)
				max = max < h ? h : max;
			cnt = 0; // cnt �ʱ�ȭ
			
		}
		
		
		answer = max;
		
		return answer;
	}
}
