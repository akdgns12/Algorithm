package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_농구경기 {
/*
 * 성의 첫 글자가 같은 선수가 5명보다 적다면, 상근이는 내일 경기를 기권.
 * 상근이는 내일 경기를 위해 뽑을 수 있는 성의 첫 글자를 모두 구해보려고 함.
 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] alpha = new int[26];
		int n = Integer.parseInt(br.readLine());
		
		//값 입력받아 해당 알파벳 자리에 1씩 추가
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			char a = s.charAt(0);
			alpha[a-97]++;
		}
		
		boolean flag = false;
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] >= 5) {
				flag = true;
				System.out.print((char)(i+97));
			}
		}
		if(!flag)
			System.out.println("PREDAJA");
	}

}
