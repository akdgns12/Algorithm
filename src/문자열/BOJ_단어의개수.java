package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_�ܾ��ǰ��� {
	/*
	 * �ܾ�� �ּ� 4���� �̻�, �ѱ��ڴ� 1������ ��� -> 10���� �̻��� �ܾ�� ������
	 * ǥ�� ���߾� ���ڴ� �ݵ�� ����ؾ� ��.
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		System.out.println(st.countTokens());
		
	}
}
