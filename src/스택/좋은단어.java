package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ_3986
// 스택
/*
 * A B A B
 * A A B B
 * A B B A
 * stack에 첫 번째 문자를 push
 * 문자열의 두번 째 부터 끝까지 탐색하면서
 * stack.peek() 스택의 탑 으로 나온 문자와 현재 탐색하고 있는 문자와 비교
 * 같으면 stack.pop
 * 다르면 stack.push
 * 전부 탐색한 후 stack.isempty() 를 통해 stack이 비어있으면 좋은단어, 비어있지 않으면 좋지 않은 단어.
 */

public class 좋은단어 {
	
	static int N;
	public static void main(String[] args)	throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int count=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			int len = str.length();
			stack.push(str.charAt(0));
			
			for(int j=1; j<str.length(); j++) {
				char nowCh = str.charAt(j);
				if(!stack.isEmpty()) {
					char prevCh = stack.peek();
					if(prevCh == nowCh) {
						stack.pop();
						continue;
					}
				}
				stack.push(nowCh);
			}
			
			if(stack.isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
		
	}
}
