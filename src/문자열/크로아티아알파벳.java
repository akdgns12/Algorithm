package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ũ�ξ�Ƽ�ƾ��ĺ� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = br.readLine();
		int result = 0;
		
		for(int i=0; i<word.length; i++) {
			if(str.contains(word[i])) {
				str = str.replaceAll(word[i], "*");
			}
		}
		
		result = str.length();
		System.out.println(result + "");
	}
}
