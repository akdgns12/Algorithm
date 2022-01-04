package Greedy;

public class 큰수만들기_level2 {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
		int idx = 0;
		int temp = 0;
		for(int i=0; i<number.length()-k; i++) {
			temp = 0;
			for(int j=idx; j<=i+k; j++) {
				if(temp < number.charAt(j) - '0') {
					temp = number.charAt(j) - '0';
					idx = j+1;
				}
			}
			answer.append(temp);
		}
	}
	
	return answer.toString();
}
