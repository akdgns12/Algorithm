package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_�Ͼ�ĭ {
/*
 * ü���� 8*8ũ��
 * ����ĭ�� �Ͼ�ĭ �����ư��鼭 ��ĥ�Ǿ�����.
 * ���� ���� ��ĭ�� (0,0) �Ͼ��.
 * ü���� ���� �־����� ��, �Ͼ� ĭ ���� ���� � �ִ��� ����ϴ� ���α׷�
 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//ü����
		char[][] map = new char[8][8];
		//�Ͼ� ĭ ���� �� ����
		int cnt = 0;
		
		String str = "";
		for(int i=0; i<8; i++) {
			str = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = str.charAt(j);
			
				//(i+j)�� 2�� ���� �������� 0�� ��� -> �Ͼ� ĭ.
				if((i+j)%2==0 && map[i][j] == 'F') {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
