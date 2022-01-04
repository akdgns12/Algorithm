package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * HashMap<Character, Integer> map = new HashMap<>();
 * 1. map�� key : 'a' , value : 1 �̷������� �־��ش�.
 */
public class ����Ѵܾ� {
	
	  public static void main(String[] args) throws IOException{
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(reader.readLine())-1;
	        String standard = reader.readLine();
	        int len = standard.length();
	        int[] alphabet = new int[26]; 
	        for(int i=0; i<len; i++) {
	            alphabet[standard.charAt(i)-'A']++;
	        }
	        
	        int ans = 0;
	        while(n-- > 0) {
	            int[] temp = alphabet.clone();
	            String comp = reader.readLine();
	            int cnt = 0;
	            for(int i=0; i<comp.length(); i++) {
	                if(temp[comp.charAt(i)-'A'] > 0) {
	                    cnt++;
	                    temp[comp.charAt(i)-'A']--;
	                }
	            }
	            if(len-1 == comp.length() && cnt == comp.length()) { //���̰� �ѱ��� ���� ��
	                ans++;
	            } else if(len == comp.length()) { //���̰� ���� ��
	                if(cnt == len || cnt == len-1) ans++;
	            } else if(len+1 == comp.length()) { //���̰� �ѱ��� Ŭ ��
	                if(cnt == len) ans++;
	            }
	        }
	        System.out.println(ans);
	    }
	}


	
