package ���ڿ�_���Խ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1013 {
	// contact / ��� 5 / ���ڿ�_���Խ�
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String str;
		
		String vega = "(100+1+|01)+"; 
				
		for(int i=0; i<T; i++) {
			str = br.readLine();
			if(str.matches(vega)) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
		
	}
}
