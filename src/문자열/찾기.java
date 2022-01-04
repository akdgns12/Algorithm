package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 백준 찾기 문제
 * 주어진 문자열 T중간에 패턴문자열이 몇번 등장하는지 cnt를 출력하고
 * 패턴문자열이 일치해서 나타나는 위치 index를 출력한다.
 * 
 */
/*
 * KMP알고리즘을 통하여 구현
 * 일치하는 문자열이 있는 경우, cnt++를 시키고, 해당 index를 li 리스트에 담는다
 * 모두 검사한 후, cnt와 li에 있는 원소를 전부 출력한다.
 * 
 */

public class 찾기 {
	static int cnt = 0;
	static ArrayList<Integer> list;
	
	public static int[] getPi(String ptn) {
		int[] pi = new int[ptn.length()];
		int j = 0;
		for(int i=1; i<ptn.length(); i++) {
			while(j > 0 && ptn.charAt(i) != ptn.charAt(j)) {
				j = pi[j-1];
			}
			if(ptn.charAt(i) == ptn.charAt(j)) 
				pi[i] = i;
		}
			return pi;
	}
		
		public static void KMP(String org, String ptn) {
			int pi[] = getPi(ptn);
			int j = 0;
			for(int i=0; i<org.length(); i++) {
				while(j > 0 && org.charAt(i) != org.charAt(j)) {
					j = pi[j-1];
				}
				if(org.charAt(i) == org.charAt(j)) {
					if(j == ptn.length() - 1) {
						++cnt;
						list.add(i - j +1);
						j = pi[j];
					}
					else
						j++;
				}
			}
		}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		list = new ArrayList<>();
		KMP(origin, pattern);
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(list.get(i));
		}
	}
}