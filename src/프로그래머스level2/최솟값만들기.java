package ���α׷��ӽ�level2;

import java.util.Arrays;
import java.util.Collections;

/*
 * �� �迭���� �� �迭�� ���̸�ŭ �ݺ��ϸ�
 * �ϳ��� �̾� ���Ѽ��� �����ؼ� ���Ѵ� �� �� �ּڰ� ���϶�
 * 
 */
//A���� ���� ������ * B���� ���� ū�� �̷������� �ϸ� �� ��?

public class �ּڰ������ {
	public int solution(int []A, int []B) {
		int answer = 0;
		 //A�������� ����
		Arrays.sort(A);
		//B�������� ����
		B = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		
		for(int i=0;i <A.length; i++) {
			
		}
		return answer;
	}
}
