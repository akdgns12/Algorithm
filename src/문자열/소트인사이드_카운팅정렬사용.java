package ���ڿ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ��Ʈ�λ��̵�_ī�������Ļ�� {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] counting = new int[10];
		int n = Integer.parseInt(br.readLine());
		
		while(n != 0) {
			counting[n%10]++;
			n /= 10;
		}
		
		for(int i=9; i>=0; i--) {
			while(counting[i] > 0) {
				System.out.print(i);
				counting[i]--;
			}
		}
	}
}
