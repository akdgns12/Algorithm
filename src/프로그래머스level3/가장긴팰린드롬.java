package ���α׷��ӽ�level3;

import java.util.*;
//���Ʈ����
/*
 *  ������ �Ӹ������ �ش� ���ڿ����� ���� �� ���
 *  (�ش� ���ڿ� �� ��ü�� ���)���� ���� ª�� ������ �ϳ��ϳ� Ȯ���ϸ鼭, 
 *  ���� �Ӹ������ ��� �ش� ���̸� ��ȯ�ϵ��� �ڵ带 �ۼ��߽��ϴ�.
 */
public class ������Ӹ���� {
	public int solution(String s) {
		char[] ch = s.toCharArray();
		
		//���� �� ���ڿ����� �Ӹ���� �˻�
		for(int len=s.length(); len>1; len--) { //len > 1 �Ӹ�����̶�� 2�����̱� ������
			//���� �ε���
			for(int start =0; start+len <= s.length(); start++) {
				boolean check = true;
				
				//ó������ ���ڿ� ������ ��ƴ��ŭ ���ڰ� ������ ��
				for(int i=0; i<len/2; i++) {
					if(ch[start + i] != ch[start + len - i -1]) {
						check = false;
						break;
					}
				}
				
				if(check) return len;
			}
		}
		return 1;
	}
}
