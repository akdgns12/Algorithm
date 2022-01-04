package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		
		int start = 0;
		
		while(n --> 0) {
			int value = Integer.parseInt(br.readLine());
			
			if(value > start) {
				// start + 1부터 입력받은 value까지 push를 한다.
				for(int i=start+1; i<=value; i++) {
					st.push(i);
					sb.append('+').append('\n');
				}
				start = value; // 다음 push할떄의 오름차순을 유지하기 위한 변수
			}
			
			// top에 있는 원소가 입력받은 값과 같지 않은 경우
			else if(st.peek() != value) {
				System.out.println("NO");
				return; 
			}
			
			st.pop();
			sb.append('-').append('\n');
		}
		
		System.out.println(sb);
		
	}

}
