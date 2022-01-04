//package Algorithm;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Alphabet {
//	public static void main(String[] args) throws IOException{
//		// BUfferedReader�� ������ ��°�� �Է¹޴� ������� ���δ�.
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		// StringBuilder�� StringBuffer�� ���� ����. synchronization�� ��� x ���Ͻ����忡���� ��밡��
//		// StringBuffer�� synchronization�� ��� ��Ƽ ������ ���α׷��ֿ��� ��� ������ StringBuilder�� �� �� ���� 
//		StringBuilder sb= new StringBuilder();
//		int[] count = new int[26];
//		
//		String input = br.readLine();
//		// charAt -> �ε����� �־��� ���� �ش��ϴ� ���ڸ� ����.
//		// length() ���ڿ��� ����, length �迭�� ����
//		for(int i=0; i<input.length(); i++) {
//			count[(int)input.charAt(i)-97]+=1;	// �ҹ��� a�� ���ڷδ� 97
//		}
//		for(int i=0; i<count.length; i++) {
//			sb.append(count[i]);
//			sb.append(" ");
//		}
//		System.out.println(sb);
//	}
//}

// 1. �⺻������ BufferedReader�� ������ ��°�� �Է¹޴� ������� �ַ� ���δ�.
// 2. readLine() �޼���� ���� �о�� ��, String������ ���๮��(���Ͱ�)�� ������ ������ ���� �о���� ���
// 3. read()�޼���� ���� �о�� ��, int������ �����Ͽ� �о���� ���.
/*
 * ���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. �� ���ĺ��� �ܾ ��� ���ԵǾ�
 * �ִ��� ���ϴ� ���α׷� �ۼ�
 * �Է� : ù° �ٿ� �ܾ� S�� �־�����. �ܾ��� ���̴� 100�� ���� ������, ���ĺ� �ҹ���
 * �θ� �̷���� �ִ�.
 * ��� : �ܾ ���ԵǾ� �ִ� a�� ����, b�� ����, ...z�� ������ ��������
 * �����ؼ� ����Ѵ�.*/
package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int[] count = new int[26];
		
		String input = br.readLine();
		
		for(int i=0;i<input.length();i++) {
			count[(int)input.charAt(i)-97]+=1;
		}
		for(int i=0;i<count.length;i++) {
			sb.append(count[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}