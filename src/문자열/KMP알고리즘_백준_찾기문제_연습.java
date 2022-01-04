package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KMP알고리즘_백준_찾기문제_연습 {

	static int cnt = 0;
	static ArrayList<Integer> list;
	public static int[] getPi(String ptn) {
		int[] Pi = new int[ptn.length()];
		int j = 0;
		for(int i=1; i<ptn.length(); i++) {
			while(j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j  = Pi[j-1];
			}
			if(ptn.charAt(i) == ptn.charAt(j))
				Pi[i] = ++j;
		}
		return Pi;
	}
	
	public static void KMP(String org, String ptn) {
		int[] Pi = new int[ptn.length()];
		int j = 0;
		for(int i=0; i<org.length(); i++) {
			while(j > 0 && org.charAt(i) != ptn.charAt(j)) {
				j = Pi[j-1];
			}
			if(org.charAt(i) == ptn.charAt(j)) {
				if(j == ptn.length()-1) {
					++cnt;
					list.add(i - j + 1);
					j = Pi[j];
				}
				else 
					j++;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		
		KMP(origin, pattern);
		System.out.println(cnt);
		for(int i=0; i<cnt;  i++) {
			System.out.println(list.get(i));
		}
	}

}
