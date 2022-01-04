package ���α׷��ӽ�_Level_1;

import java.util.Arrays;

/*
 * �Լ� solution�� ���� n�� �Ű������� �Է¹޴´�. n�� �� �ڸ����� ū�ͺ���
 * ���� ������ ������ ���ο� ������ return�϶�.
 * ���� ��� n�� 118372�� 873211�� return�ϸ� �ȴ�.
 */
public class ���������������ι�ġ {
	/*
	 * 01 - �Է��� ���� �� �ڸ������� String �迭�� ��´�
	 * 02 - �迭�� ��� ������ �������� �����Ѵ�.(Collections�� Ȱ���ϸ� �������� ���ĵ� ����)
	 * 03 - �������� ������ ���� �迭�� ��� ������ �������� nStr�� ����(���������̱� ������ �������� �����ϸ� ��������)
	 */
	public long solution(long n) {
		String[] nArr = String.valueOf(n).split(""); //01
		Arrays.sort(nArr); //02
		
		String nStr = new String("");
		for(int i=nArr.length-1; i>=0; i--) //03
			nStr += nArr[i];
					
		return Long.parseLong(nStr);
	}
}
