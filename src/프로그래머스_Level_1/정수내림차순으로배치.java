package 프로그래머스_Level_1;

import java.util.Arrays;

/*
 * 함수 solution은 정수 n을 매개변수로 입력받는다. n의 각 자릿수를 큰것부터
 * 작은 순으로 정렬한 새로운 정수를 return하라.
 * 예를 들어 n이 118372면 873211을 return하면 된다.
 */
public class 정수내림차순으로배치 {
	/*
	 * 01 - 입력한 수를 각 자리수별로 String 배열에 담는다
	 * 02 - 배열에 담긴 수들을 오름차순 정렬한다.(Collections를 활용하면 내림차순 정렬도 가능)
	 * 03 - 내림차순 정렬을 위해 배열에 담긴 수들을 역순으로 nStr에 저장(오름차순이기 때문에 역순으로 저장하면 내림차순)
	 */
	public long solution(long n) {
		String[] nArr = String.valueOf(n).split(""); //01
		Arrays.sort(nArr); //02
		
		String nStr = new String("");
		for(int i=nArr.length-1; i>=0; i--) //03
			nStr += nArr[i];
					
		return Long.parseLong(nStr);
	}
}
