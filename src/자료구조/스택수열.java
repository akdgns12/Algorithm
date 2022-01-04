package �ڷᱸ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ���ü��� {

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
				// start + 1���� �Է¹��� value���� push�� �Ѵ�.
				for(int i=start+1; i<=value; i++) {
					st.push(i);
					sb.append('+').append('\n');
				}
				start = value; // ���� push�ҋ��� ���������� �����ϱ� ���� ����
			}
			
			// top�� �ִ� ���Ұ� �Է¹��� ���� ���� ���� ���
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
