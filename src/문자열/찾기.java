package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * ���� ã�� ����
 * �־��� ���ڿ� T�߰��� ���Ϲ��ڿ��� ��� �����ϴ��� cnt�� ����ϰ�
 * ���Ϲ��ڿ��� ��ġ�ؼ� ��Ÿ���� ��ġ index�� ����Ѵ�.
 * 
 */
/*
 * KMP�˰����� ���Ͽ� ����
 * ��ġ�ϴ� ���ڿ��� �ִ� ���, cnt++�� ��Ű��, �ش� index�� li ����Ʈ�� ��´�
 * ��� �˻��� ��, cnt�� li�� �ִ� ���Ҹ� ���� ����Ѵ�.
 * 
 */

public class ã�� {
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