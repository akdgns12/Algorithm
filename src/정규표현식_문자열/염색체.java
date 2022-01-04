package ����ǥ����_���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ����ü {
	// BOJ 9342 / ����ü / ����ǥ���� / �� 2
	static int T;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		/*
		 * [] : ������ ����, ������ ��Ÿ��. �� ���� ���̴� -��ȣ�� ������ ��Ÿ��
		 * []���� ^�� �����Ͽ� �����ϸ� not�� ��Ÿ��
		 */
		String regex = "^[A-F]?A+F+C+[A-F]?$";
		// ���� 1
		//  ^ : ���ڿ��� ����
		//  [A-F]? : a���� ~ F������ ���� ���ų� �ϳ�����
		// ���� 2,3,4 
		// A+ : A�� �ϳ� �̻�
		// F+ : F�� �ϳ� �̻�
		// C+ : C�� �ϳ� �̻�
		// ���� 5
		// [A-F]? : A���� F������ ���� ���ų� �ϳ�����
		// $ : ���ڿ� ����
		for(int i=0; i<T; i++) {
			String word = br.readLine();
			if(word.matches(regex)) {
				System.out.println("Infected!");
			}else {
				System.out.println("Good");
			}
		}
	}
}
