package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//(100+ 1+ | 01)+
//����ǥ������ �˰��ִ����� ���� ����
//���α׷��ӽ� "�ҷ������"�� ����� ����

/*
 * �� �������� ���� ����ǥ����
 * str.matches(regex)�Լ� : str�� ����ǥ������ regex�� ��ġ�ϴ��� Ȯ��
 * () : ��ȣ ���� ���ڸ� �ϳ��� ���ڷ� �ν�
 *  | : ���� �ȿ��� or ���� ����
 *  + : �ٷ� �� ���ڰ� �ϳ� �̻�
 */
public class BOJ_contact {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		String vega = "(100+1+|01)+";
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			if(str.matches(vega))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}

}
