package ¹®ÀÚ¿­;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class °ýÈ£ {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-->0) {
			boolean isVPS = true;
			String str = br.readLine();
			Stack<Character> st = new Stack<Character>();
			
			for(int i=0; i<str.length(); i++) {
				char c= str.charAt(i);
				
				if(c == '(') {
					st.push(c);
				}else if(c == ')') {
					if(!st.isEmpty()) {
						st.pop();
					}else {
						isVPS = false;
						break;
					}
				}
			}
			
			if(!st.isEmpty()) isVPS = false;
			
			if(isVPS) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}

}
