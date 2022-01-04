package ���ڿ�;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_�ܾ�����_comparator��� {
	
	/*
	 * ���ĺ� �ҹ��ڷ� �̷���� N���� �ܾ ������ �Ʒ��� ���� ���ǿ� ���� �����ϴ� ���α׷�
	 * 1.���̰� ª�� �� ����
	 * 2.���̰� ������ ���� ������
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			//compare() �� ���ϰ��� ����� �� ��ü�� �ڸ��� �ٲ��ִ� ����
				public int compare(String o1, String o2) { // ���ڿ� �迭 ���� �������� ����
				if(o1.length() == o2.length()) { // �� ���ڿ��� ���̰� ���� ����
					return o1.compareTo(o2); //���������� ����
				}else {//�� �ܿ��� ���ڿ����� ���̷� ��
					return o1.length() - o2.length();
					
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			if(i+1 != n) {
				if(str[i].equals(str[i+1])) {//���� �ε����� ���� �ε����� �ش��ϴ� ��Ұ� ������ Ȯ��.
					continue;
				}
			}
			bw.write(str[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
