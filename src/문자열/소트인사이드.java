package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ��Ʈ�λ��̵� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		String[] split = n.split("");
		int[] arr = new int[split.length];
		for(int i=0; i<split.length; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		
		Arrays.sort(arr);
		for(int i=arr.length-1; i>=0; i--)
			System.out.print(arr[i]);
	}
}
