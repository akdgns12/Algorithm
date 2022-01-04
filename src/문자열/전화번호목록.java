package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ��ȭ��ȣ��� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			int n = Integer.parseInt(br.readLine());
			String[] phone_number = new String[n]; // ��ȭ��ȣ ���
			
			for(int i=0; i<n; i++) {
				phone_number[i] = br.readLine(); 
			}
			Arrays.sort(phone_number); //������������ ����
			
			if(isConsistent(n, phone_number)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
	public static boolean isConsistent(int n, String[] phone_number) {
		/*
		 * ���� �迭�� ������������ ���ĵǾ� �ִ� ����
		 * ���� ��ȭ��ȣ ��� �ȿ� ���ξ� ���谡 �ִ� ���ڿ��� �ִٸ�
		 * Ư�� ���ڿ� �ٷ� �ڿ� ���ξ� ���谡 �ִ� ���ڿ��� ���� ���̴�.
		 * ���������, ��ȭ��ȣ ����� �ϰ����� �ִ��� �˻��Ϸ���
		 * Ư�� ���ڿ��� �� ���� ���ڿ��� ���ξ� ���踸 Ȯ���ϸ� �ȴ�.
		 */
		for(int i=0; i<n-1; i++) {
			if(phone_number[i+1].startsWith(phone_number[i])) {
				return false;
			}
		}
		return true;
	}
}