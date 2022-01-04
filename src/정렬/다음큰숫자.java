package 정렬;

public class 다음큰숫자 {
	public int solution(int n) {
		int answer = 0;
		
		//n을 2진수로 변환
		String str = Integer.toBinaryString(n);
		//n의 1인 비트의 수를 저장하는 변수
		int cnt = 0;
		//n의 1인 비트의 수를 카운팅
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '1') cnt++;
		}
		//n+1부터 반복
		for(int i=n+1; i<1000000; i++ ) {
			String temp = Integer.toBinaryString(i);
			int temp_cnt = 0;
			for(int j=0; j<temp.length(); j++) {
				if(temp.charAt(j) == '1') temp_cnt++;
			}
			
			if(temp_cnt == cnt) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}
}