package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_���ϱ����Ŭ {
/*
 * �־��� �� n < 10 �̸� �տ� 0�� �ٿ� ���ڸ� �� ���� ��, �� �ڸ��� ���ڸ� ����
 * �־��� �� n�� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸�
 * ���ο� ���� ���� �� ����.
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int copy = n;
		
		do {
			n = ((n%10)*10) + ((n/10) + (n%10)%10);
			cnt++;
		}while(copy != n);
		
		System.out.println(cnt);
	}

}
