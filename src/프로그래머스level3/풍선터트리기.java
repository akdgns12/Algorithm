package ���α׷��ӽ�level3;

import java.util.HashSet;

public class ǳ����Ʈ���� {
	public int solution(int[] a) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		int min = a[0];
		//���ٹ��
		//left,right ������� 2���� ǳ���� �������� ������ ��,
		//���� ����,������ ǳ���� ���������� ���� �� �ִ�.
		//��� ǳ���� ���, left�� right�� �ϳ��� �Ǳ����ؼ��� ��,������
		//���ڰ� �۾ƾ��Ѵ�.
		
			for(int i=1; i<a.length; i++) {
				set.add(min);
				min = Math.min(a[0], min);
			}
			
			min = a[a.length-1];
			for(int i=a.length-2; i>=0; i--) {
				set.add(min);
				min = Math.min(a[i], min);
			}
		
		
		
		return set.size();
	}
}
