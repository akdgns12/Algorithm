package �����ڵ�;

import java.util.Scanner;

public class �Ӹ���Ҹ����_BOJ1213 {
	// BOJ �Ӹ����_����� ��4 / ���̵�� 
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		String str = sc.next();
		int[] a = new int[26];
		for(int i=0; i<str.length(); i++) {
			a[str.charAt(i) - 'A']++;
		}
		// ���̰� ¦���� ��� ���ĺ��� ������ ¦������ ��
		// ���̰� Ȧ���� �ϳ��� ���ĺ� ������ Ȧ������ ��
		int oddCnt = 0, oddIdx = 0;
		
		for(int j=0; j<a.length; j++) {
			if(a[j] % 2 == 1) {
				oddCnt++;
				oddIdx = j;
			}
		}
		
		
		if((str.length() % 2 == 0 && oddCnt > 0) | (str.length() % 2 == 1 && oddCnt != 1)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		
		
	}
}
