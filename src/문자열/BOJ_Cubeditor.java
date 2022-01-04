package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//KMP알고리즘 활용문제
//KMP복습, KMP알고리즘이란 : 어떤 문자열안에 특정 문자열일 몇개나 있는지 찾는 알고리즘
public class BOJ_Cubeditor {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		//입력에서 주어진 문자열의 두 번이상 나오는 부분문자열에서 가장 긴  길이를 출력한다.
		int n = str.length();
		int max = 0;
		//해당 문제에서 두번이상 나오는 부분 문자열 중에서 가장 길이가 긴 값을 구하는 것.
		//Pi를 통해 가장 길이가 긴 접두사 == 접미사인 경우 찾으면 최대길이가 될 수도 있지만 반례 존재한다
		// ABBCBBA와 같이 문제의 경우에 맞는 최대길이는 BB로 2인데 Pi는 A 1이다.
		// 그래서 getMax를 호출할 때 i를 늘려가며 n-1까지 문자열을 잘라서 비교해주며 최대값을 리턴할 수 있도록 한다.
		
		for(int i=0; i<n; i++) {
			max = Math.max(max, getMax(str.substring(i,n)));
		}
		System.out.println(max);
	}
	
	//문자열 s에서 최대 부분 문자열의 길이를 출력하는 문제
	public static int getMax(String s) {
		int j = 0, n = s.length(), max = 0;
		int pi[] = new int[n];
		for(int i=1; i<n; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j-1];
		if(s.charAt(i) == s.charAt(j)) max = Math.max(max, pi[i] = ++j);
		}
		return max;
	}
}
