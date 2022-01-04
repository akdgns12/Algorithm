package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_�ܾ���� {
/*
 * ���ĺ� ��ҹ��ڷ� �� �ܾ �־�����,
 * �� �ܾ�� ���� ���� ���� ���ĺ��� �������� �˾Ƴ��� ���α׷�
 * 
 */
	/*
	 * <�ذ���>
	 * ���� ������ ���ĺ��� ���� �󵵼��� üũ�ϱ� ���� alpha[ ] �迭�� ������־����ϴ�.
�Է¹��� str�� �� ���ھ� �߶� ���鼭 alpha �迭�� ī��Ʈ�� 1�� ���������־� �� �� �����ߴ��� �� �� �ֵ��� ���־����ϴ�.
ī������ �Ϸ��� ���� max�� max_idx�� ����� max�� ���� ���� �󵵼�, idx�� max���� ���� ���ڸ� ����ϱ� ���� �� ������ ����߽��ϴ�.
�߰������� max���� �Ȱ��� ���,  ? �� ������־�� �ϱ� ������ �̸� �����ϱ� ���� flag ������ ��������ϴ�.
���ο� max���� ������ �� if�� �ȿ��� flag�� false�� �ʱ�ȭ���־���,
���� �Ȱ��� max ���� �߻��Ѵٸ� flag�� true�� �ٲ� �� ��쿡�� �����? �� ������־����ϴ�.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		String str = br.readLine().toUpperCase();
		boolean flag = false;
		int max = 0;
		int max_idx = 0;
		
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}
		
		for(int i=0; i<alpha.length; i++) {
			if(max < alpha[i]) {
				max = alpha[i];
				flag = false;
				max_idx = i;
			}else if(max == alpha[i]) {
				flag = true;
			}
		}
		if(flag == true)
			System.out.println("?");
		else
			System.out.println((char)('A' + max_idx));
	}	
}
