package ��ȭ������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 1. ���Ʈ ������ ������ Ǫ�� ����� �ְ� = ���� �� ���...
 * 2. �� ���� �ڸ����� ���� ���� ����� ���� ���� �����ϴ� ����� �ִ�.
 */

public class BOJ_��ȭ������_1436 {

	static int n;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;
		while( n != cnt) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}

/*
 * contains , valueof ���� �ٽ��ѹ� �ľ��ص��� ���� ����.
 * String.valueOf() int�� String���� ��ȯ�Ѵ�.
 */