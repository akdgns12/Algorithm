package 프로그래머스_Level_1;
/*
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해
 * 새로운 문자열을 리턴하는 함수, solution
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것을 간주
 */
public class 문자열내림차순으로배치하기 {
	public String solution(String s) {
		String answer = "";
		
        String[] sArr = s.split("");
        String tmp;

        /**
         * 버블 정렬
         */
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 0; j < s.length() - 1 - i; j++) {
                if (sArr[j].charAt(0) < sArr[j + 1].charAt(0)) {
                    tmp = sArr[j];
                    sArr[j] = sArr[j + 1];
                    sArr[j + 1] = tmp;
                }
            }
        }

        answer = String.join("", sArr);

		return answer;
	}
}
/*
 * Collections.reverseOrder() 사용
 * class Solution {
 * public String solution(String s){
 * 	String answer = "";
 * 	String[] sArr = s.split("");
 * 
 *  Arrays.sort(sArr, Collections.reverseOrder());
 *  answer = String.join("", sArr);
 *  
 *  return answer;
 *  }
 *  }
 * 
 * 
 */
	