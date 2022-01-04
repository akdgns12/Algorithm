package ���ڿ�;

import java.util.Scanner;

public class IOIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * ������ ������ ã�� ���ڿ� ��Ī �˰���
		 * Pn�� IOI�� N�� ��ŭ �ݺ��Ǵ� �����̱� ������, for���� �����
		 * ������ IOI������ ã�� Ƚ���� �� �� N�� ���ϴ� ������� ����
		 * �ð����⵵ O(n)
		 * 
		 * ����
		 * Pn�� IOI�� N����ŭ �ݺ��Ǵ� ����
		 * ��, �� index�� ���� IOI������ �����ϴ��� Ȯ���ϰ� ���ӵ�
		 * Ƚ���� �� ��, N�� ��ġ�� ��� ��� ���� 1�÷��ָ� �ȴ�
		 * ���⼭ ������ ������ ��� ���ؾ� �� �ൿ��
		 * 1. ���� ����Ƚ���� 1 ���δ�.
		 *  - IOI�� ���ӵ� �� ������ ��� Pn�� �������� ��Ÿ���� ������
		 * 2. 2ĭ �ڷ� �̵��� ������ ���ӵǴ��� Ȯ���Ѵ�.
		 *  - ���� ��� �ڽ��� 0�̰�, ��,�ڰ� I�϶� ������ �����Ѵٴ� �����̹Ƿ�
		 */
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] c = sc.next().toCharArray();
		
		int result = 0;
		int patternCnt = 0;
		for(int i=1; i<m-1; i++) {
			if(c[i-1] == 'I' && c[i] == 'O' && c[i+1] == 'I') {
				patternCnt++;
				if(patternCnt == n) {
					patternCnt--;
					result++;
				}
				i++;
			}else patternCnt = 0;
		}
		System.out.println(result);
	}
}
