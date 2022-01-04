package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8진수2진수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String n = br.readLine();
		
		String[] binary = {"000","001","010","011","100","101","110","111"};
		for(int i=0; i<n.length(); i++) {
			int octa = n.charAt(0) - '0';
			String bin = binary[octa];
			
			if(i==0) {
				if(bin.startsWith("000")) {
					System.out.println("0");
				}else if(bin.startsWith("00")) {
					System.out.println(bin.charAt(2));
				}else if(bin.startsWith("0")) {
					System.out.println(bin.charAt(1));
					System.out.println(bin.charAt(2));
				}else {
					System.out.println(bin);
				}
			}else {
				System.out.println(bin);
			}
		}
	}

}
