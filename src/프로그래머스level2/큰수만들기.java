package 프로그래머스level2;

/*
 * <알고리즘>
 * 만약 리턴해야하는 값이 4자리의 수라면, 입력값에서 맨 뒤의 3자리를 제외한
 * 문자열 부분에서 가장 큰 수를 찾는다. 그리고나서 큰 수를 찾은 자리 이후부터
 * 마지막 2자리를 제외한 곳에서 큰값을 찾는다. 이 과정을 반복
 * ex) 5678543 => 5,6,7,8 중 가장 큰 수 8
 */
public class 큰수만들기 {
	public String solution(String number, int k) {
		StringBuilder answer = new StringBuilder();
		
		int idx = 0;
		char max;
		if(number.charAt(0)== '0')	return "0";
		for(int i=0; i<number.length()-k; i++) { // number에서 k자리만큼 뺸 곳까지만
			max = '0';
			//j의 시작을 idx로 잡은 이유는 이미 선택한 최댓값을 지나치기 위해서
			for(int j=idx; j<=i+k; j++) {
				if(max < number.charAt(j)) {
					max = number.charAt(j);
					idx = j+1;
				}
			}
			answer.append(max);
		}
		
		return answer.toString();
	}
}
