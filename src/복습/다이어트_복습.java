package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ���̾�Ʈ_���� {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		
		/*
		 * G���� = ��������� ���� - �˴� ������ ����
		 * G + �˴� ������ = ���� ������
		 */
		int start = 1;  // ���� ������
		int end = 1; // �˴� ������
		boolean flag = false;
		
		while(true) {
			long weight = (long)(Math.pow(start, 2) - Math.pow(end, 2));
			if(start - end == 1 && weight > G) break;
			if(weight >= G)
				end--;
			else
				start++;
			
			if(weight == G) {
				System.out.println(start);
				flag = true;
			}
		}
		
		if(flag)
			System.out.println(-1);
	}

}
