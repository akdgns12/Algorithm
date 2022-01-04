package 와디즈코테8_21;

import java.util.Stack;

public class _3번{
	static int answer = 0;
	public static int solution(int[] arr) {
		Stack<Integer> st = new Stack<>();
		
		st.push(0);

		//int idx = 0;
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			while(st.peek() > arr[i]) {
				st.pop();
				//idx--;
			}
			if(st.peek() < arr[i]) {
				st.push(arr[i]);
			//	idx++;
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		_3번 solution = new _3번();
		//int[] arr = {10,0,10,0,10,0};
		//int[] arr = {1,2,4,8,4,2,1};
		//int[] arr = {1,3,5,7,6,8,9,5,1};
		//int[] arr = {5,4,5,4,5,5};
		System.out.println(_3번.solution(arr));
	}
}