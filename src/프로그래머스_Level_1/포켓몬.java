package ���α׷��ӽ�_Level_1;

import java.util.HashSet;

/*
 * �����ǿ� �ִ� �� N������ ���ϸ� �� N/2������ �������� ����
 * �ߺ� ��� x
 * hashset�� �ߺ� ��� x
 */
public class ���ϸ� {
	public int solution(int[] nums) {
				
		int max = nums.length/2;
		
		//�ߺ� �����ϱ�
		HashSet<Integer> numsSet = new HashSet<>();
		
		for(int num : nums) {
			numsSet.add(num);
		}
		
		// �ߺ��� ������ ���� ũ�Ⱑ max���� ũ�� max��, ������ numsSet�� size�� ����
		if(numsSet.size()>max) {
			return max;
		} else {
			return numsSet.size();
		}
	}
}
