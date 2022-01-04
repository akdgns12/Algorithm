package 스택_큐;
import java.util.*;

public class 짝지어제거하기 {
	public int solution(String s) {
		int answer = 0;
		Stack<String> st = new Stack<String>();
		
		for(int i=0; i<s.length(); i++) {
			if(st.isEmpty()) {
				st.push(String.valueOf(s.charAt(i)));
			}else {
				String lastval = st.peek();
				String currval = String.valueOf(s.charAt(i));
				if(!lastval.equals(currval)) {
					st.push(currval);
				}else {
					st.pop();
				}
			}
		}
		
		return st.size() == 0 ? 1 : 0;
	}
}
