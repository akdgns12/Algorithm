import java.util.Collections;
import java.util.PriorityQueue;


public class ���ڿ����� {
	public int solution(String s) {
		int answer = s.length();
		//���ڿ��� �ݱ����� ���ص� �ȴ� ->�� �̻� �����ϴ� �� ������ �ȵǱ⶧��
		for(int i=1; i<=s.length()/2; i++) {
			StringBuilder sb =new StringBuilder();
			String preString = s.substring(0, 0+i);
			
			int cnt = 1; //���ڿ��� ��� �ݺ��Ǿ��°� �� cnt
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
