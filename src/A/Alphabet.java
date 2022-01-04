//package Algorithm;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Alphabet {
//	public static void main(String[] args) throws IOException{
//		// BUfferedReader는 한줄을 통째로 입력받는 방법으로 쓰인다.
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		// StringBuilder는 StringBuffer와 같은 역할. synchronization을 허용 x 단일스레드에서만 사용가능
//		// StringBuffer는 synchronization을 허용 멀티 쓰레드 프로그래밍에서 사용 성능은 StringBuilder가 좀 더 빠름 
//		StringBuilder sb= new StringBuilder();
//		int[] count = new int[26];
//		
//		String input = br.readLine();
//		// charAt -> 인덱스로 주어진 값에 해당하는 문자를 리턴.
//		// length() 문자열의 길이, length 배열의 길이
//		for(int i=0; i<input.length(); i++) {
//			count[(int)input.charAt(i)-97]+=1;	// 소문자 a가 숫자로는 97
//		}
//		for(int i=0; i<count.length; i++) {
//			sb.append(count[i]);
//			sb.append(" ");
//		}
//		System.out.println(sb);
//	}
//}

// 1. 기본적으로 BufferedReader는 한줄을 통째로 입력받는 방법으로 주로 쓰인다.
// 2. readLine() 메서드는 값을 읽어올 때, String값으로 개행문자(엔터값)를 포함해 한줄을 전부 읽어오는 방식
// 3. read()메서드는 값을 읽어올 때, int값으로 변경하여 읽어오는 방식.
/*
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇개가 포함되어
 * 있는지 구하는 프로그램 작성
 * 입력 : 첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자
 * 로만 이루어져 있다.
 * 출력 : 단어에 포함되어 있는 a의 개수, b의 개수, ...z의 개수를 공백으로
 * 구분해서 출력한다.*/
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