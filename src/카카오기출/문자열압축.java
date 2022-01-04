import java.util.Collections;
import java.util.PriorityQueue;


public class 문자열압축 {
	public int solution(String s) {
		int answer = s.length();
		//문자열의 반까지만 비교해도 된다 ->그 이상 압축하는 건 압축이 안되기때문
		for(int i=1; i<=s.length()/2; i++) {
			StringBuilder sb =new StringBuilder();
			String preString = s.substring(0, 0+i);
			
			int cnt = 1; //문자열이 몇번 반복되었는가 셀 cnt
			for(int j=i; j<s.length(); j= j+i) {
				String tmp = s.substring(j, j+i < s.length() ? j+i : s.length());
				if(tmp.equals(preString)) {
					cnt++;
				}else {
					if(cnt==1) {
						sb.append(preString);
					}else {
						sb.append(cnt);
						sb.append(preString);
					}
					cnt=1;
					preString = tmp;
				}
			}
			
			if(cnt==1) {
				sb.append(preString);
			}else {
				sb.append(cnt);
				sb.append(preString);
			}
			if(sb.length() < answer) {
				answer = sb.length();
			}
		}
		return answer;
}
}
