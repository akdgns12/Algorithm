package �����ڵ�;

public class ����_���ڿ�����2 {
	public int solution(String s) {
		int answer = 0;
		int len = s.length();
		
		for(int i=1; i<=s.length()/2; i++) {
			String str = s.substring(0, i);
			String temp = "";
			int count = 1;
			int lastIndex = 0;
			
			for(int j=i; j+i<=len; j+=i) {
				String strToCompare = s.substring(j,j+i);
				
				if(str.equals(strToCompare)) {
					count++;
				}else {
					if(count > 1) { // 1���� ������ count �����̹Ƿ� üũ�������
						temp += count;
						count = 1;	
					}
					temp += str;
					str = strToCompare;
				}
				lastIndex = j + i;
			}
			
			if(count > 1) {
				temp += count;
				temp += str;
			}
			
			if(lastIndex < len) {
				temp += s.substring(lastIndex);
			}
			
			answer = Math.min(answer, temp.length());
		}
		
		return answer;
	}
}
