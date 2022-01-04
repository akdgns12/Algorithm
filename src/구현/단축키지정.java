package ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class ����Ű���� {
	// BOJ 1283 ����Ű ���� / �ǹ� 3 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 
		int N = Integer.parseInt(br.readLine());
		HashSet<Character> set = new HashSet<>(); // ����Ű�� �����ϴ� set
		ArrayList<String> result = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			String[] data1 = word.split(" ");
			String[] data2 = word.split("");
			if(case1(data1, set)) { // �ܾ���� �������� ������ ���� ��
				
			}else if(case2(word, data2, set)) {
				
			}else {
				System.out.println(word);
			}
		}
	}
	
	public static boolean case1(String[] data1, HashSet<String> set) {
		for(int i=0; i<data1.length; i++) {
			String s = data1[i];
			String t = s.substring(0,1).toUpperCase(); // data[i]�� ù���� 
			if(!set.contains(t)) {
				set.add(t);
				for(int j=0; j<data1.length; j++) {
					if(j == i) {
						System.out.println("[" + s.substring(0,1) + "]" + s.substring(1) + " ");
					}else {
						System.out.println(data1[j] + " ");
					}
				}
				System.out.println();
				return true;
			}
		}
		return false;
	}
	
	public static boolean case2(String word, String[] data2, HashSet<String> set) {
		for(int i=0; i<data2.length; i++) {
			String s = data2[i].toUpperCase();
			
			if(s.equals(" ")) {
				continue;
			}
			
			if(!set.contains(s)) {
				set.add(s);
				System.out.println(s.substring(0,i) + "[" + word.substring(i,i+1) + "]" + word.substring(i+1) + "\n");
				return true;
			}
		}
		return false;
	}
}
