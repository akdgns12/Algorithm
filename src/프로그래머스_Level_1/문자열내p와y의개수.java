package ���α׷��ӽ�_Level_1;

import java.util.ArrayList;

/*
 * �빮�ڿ� �ҹ��ڰ� �����̴� ���ڿ� s�� �־�����
 * s�� p�� ������ y�� ������ ���� ������ True, �ٸ��� False return
 * p,y ��� �ϳ��� ���� ���� �׻� True
 * ��, ������ ���� �� ��ҹ��� ���� x
 */
public class ���ڿ���p��y�ǰ��� {
	boolean solution(String s) {
		boolean answer = true;
		int cnt = 0;
		char ch = ' ';
		
		for(int i=0; i<s.length(); i++) {
			ch = s.charAt(i);
			if(ch == 'p' || ch == 'P')
				cnt++;
			else if(ch == 'y' || ch == 'Y')
				cnt--;
		}
		if(cnt !=0 )
			return false;
		return true;
	}
}
