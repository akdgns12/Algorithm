package ����ǥ����_���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1013 {
	// Contact / ��� 5 / ����ǥ����
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		/*
		 * () : �Ұ�ȣ ���� ���ڸ� �ϳ��� ���ڷ� �ν�
		 *  | : ���� �ȿ��� or ������ ������ �� ���
		 */
		String regex = "(100+1+|01)+";
		
		for(int i=0; i<T; i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}
