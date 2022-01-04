package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//KMP�˰��� Ȱ�빮��
//KMP����, KMP�˰����̶� : � ���ڿ��ȿ� Ư�� ���ڿ��� ��� �ִ��� ã�� �˰���
public class BOJ_Cubeditor {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//�Է¿��� �־��� ���ڿ��� �� ���̻� ������ �κй��ڿ����� ���� ��  ���̸� ����Ѵ�.
		int n = str.length();
		int max = 0;
		//�ش� �������� �ι��̻� ������ �κ� ���ڿ� �߿��� ���� ���̰� �� ���� ���ϴ� ��.
		//Pi�� ���� ���� ���̰� �� ���λ� == ���̻��� ��� ã���� �ִ���̰� �� ���� ������ �ݷ� �����Ѵ�
		// ABBCBBA�� ���� ������ ��쿡 �´� �ִ���̴� BB�� 2�ε� Pi�� A 1�̴�.
		// �׷��� getMax�� ȣ���� �� i�� �÷����� n-1���� ���ڿ��� �߶� �����ָ� �ִ밪�� ������ �� �ֵ��� �Ѵ�.
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, getMax(str.substring(i,n)));
		}
		System.out.println(max);
	}
	
	//���ڿ� s���� �ִ� �κ� ���ڿ��� ���̸� ����ϴ� ����
	public static int getMax(String s) {
		int j = 0, n = s.length(), max = 0;
		int pi[] = new int[n];
		for(int i=1; i<n; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j-1];
		if(s.charAt(i) == s.charAt(j)) max = Math.max(max, pi[i] = ++j);
		}
		return max;
	}
}
