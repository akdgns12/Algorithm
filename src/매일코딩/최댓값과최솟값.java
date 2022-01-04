import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
		String[] str = s.split(" ");
		int max, min, n;
		min = max = Integer.parseInt(str[0]);
		
		for(int i=0; i<str.length; i++) {
			n = Integer.parseInt(str[i]);
			if(max < n)
				max = n;
			if(min > n)
				min = n;
		}
		
		
		return answer = min + " " + max;
    }
}