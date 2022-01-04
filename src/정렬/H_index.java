package ����;

import java.util.ArrayList;
import java.util.Arrays;

public class H_index {
	//�� n���� ,h�� �̻� �ο�� ���� h���̻��̰� 
	// ������ ���� h�� ���� �ο�Ǿ��ٸ� h�� �ִ��� �� �������� H-Index
	//H-Index ����
	//���� �ο� Ƚ���� ���� �迭 citations
	public int solution(int[] citations) {
		int len = citations.length;
		Arrays.sort(citations);
		int max = 0;
		int cnt = 0;
		//�������� �����س���, citations�� ���� ū���ұ��� h������Ű�� �ݺ�
		for(int h=0; h<=citations[len-1]; h++) {
			//�ο�Ƚ�� h���� ū �ο빮�� ���� ã��
			for(int i=0; i<len; i++) {
				if(h<=citations[i])
					cnt++;
			}
			
			//h���� ū �ο빮�� ������ h�̻��̸� max���� update
			if(cnt >= h)
				max = max < h ? h : max;
			cnt = 0; //cnt �ʱ�ȭ
		}
		
		return max;
	}
}
