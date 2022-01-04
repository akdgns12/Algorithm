package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ȸ�� {
	static int T;
	static char[] arr;
	static String str;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		// 0 : ȸ��, 1 : ����ȸ��, 2 : �Ϲ� ���ڿ�
		for(int t = 0; t<T; t++) {
			str = br.readLine();
			arr = str.toCharArray();
			int left = 0;
			int right = str.length()-1;
			if(check(left, right)) { // ȸ������ �˻�
				System.out.println(0);
				continue;
			}
			if(checkS(left, right)) { // ����ȸ�� �˻�
				System.out.println(1);
			}else { // ���� �ΰ��� �����Լ��� �ش���� �ʴ´ٸ� �� �� �Ϲ� ���ڿ�
				System.out.println(2);
			}
		}
}
	
	// �� ������ ���س����ٰ� �ٸ� �κп��� �� �� �ϳ� �����غ��� ȸ���� �´���
	// �˻��ϸ� �Ǵ� ����, ��� ���� �����غ� �ʿ� ���� ó�� �޶����� �κи�! �����ϸ� �ȴ�.
	public static boolean check(int left, int right) {
		while(left <= right) {
			if(arr[left] != arr[right]) {// �ٸ�
				return false;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}
	// ����ȸ�� �˻�
	public static boolean checkS(int left, int right) {
		while(left <= right) {
			if(arr[left] != arr[right]) { // �ٸ�
				boolean a = check(left+1, right);
				boolean b = check(left, right-1);
				if(a == false && b == false) {
					return false;
				}else return true;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}
}
