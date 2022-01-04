package 汗嚼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 促捞绢飘_汗嚼 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		
		/*
		 * G力蚌 = 泅犁个公霸 力蚌 - 舅带 个公霸 力蚌
		 * G + 舅带 个公霸 = 泅犁 个公霸
		 */
		int start = 1;  // 泅犁 个公霸
		int end = 1; // 舅带 个公霸
		boolean flag = false;
		
		while(true) {
			long weight = (long)(Math.pow(start, 2) - Math.pow(end, 2));
			if(start - end == 1 && weight > G) break;
			if(weight >= G)
				end--;
			else
				start++;
			
			if(weight == G) {
				System.out.println(start);
				flag = true;
			}
		}
		
		if(flag)
			System.out.println(-1);
	}

}
