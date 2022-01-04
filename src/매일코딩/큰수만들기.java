package �����ڵ�;

public class ū������� {
 // LV2 ���α׷��ӽ� ū������� / �׸��� /
	import java.util.Arrays;
	import java.util.Comparator;
	class Solution {
	    public String solution(String number, int k) {
	      StringBuilder answer = new StringBuilder();
			int idx = 0;
			char max;
			for(int i=0; i<number.length() - k; i++) {
				max = '0';
				
				for(int j=idx; j<=k+i; j++) {
					if(max < number.charAt(j)) {
						max = number.charAt(j); //
						idx = j+1;
					}
				}
				
				answer .append(max);
			}
			return answer.toString();
	    }
	}
}

/*
 * import java.util.*;

class Solution {
    // �ξ� �������� Ǯ��
    public String solution(String number, int k) {
        Stack<Character> st = new Stack<>();
        char[] result = new char[number.length() - k];
        
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            while(!st.isEmpty() && st.peek() < c && k --> 0){
                st.pop();
            }
            st.push(c);
        }
        
        for(int i=0; i<result.length; i++){
            result[i] = st.get(i);
        }
        
        return new String(result);
    }
}
*/
