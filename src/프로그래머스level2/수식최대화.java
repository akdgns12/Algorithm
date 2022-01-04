package 프로그래머스level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 * 주어진 연산수식이 담긴 문자열 expression의 순서를
 * 임의로 정의하여 절댓값이 가장 큰 금액을 return
 * 
 */
// 존나 어려워 씨발
// 조오오오오온나 어렵다 씨빨
/*
 * 1. 완전탐색을 이용해 수식의 모든 조합을 구해준다.
 * 2. 기존 수식 중 조합의 순서와 맞는 경우를 발견하면 앞뒤 숫자와 수식으로 계산한 후 다시 list에 넣어준다.
 * 3. 2번을 반복한 후 더 큰값을 비교한다.
 */
// 1. -,+,* 별로 걸러준다
public class 수식최대화 {
	static char[] cal = {'+','-','*'};// 조합에 사용
	static char[] temp = new char[3]; //모든 조합
	static boolean[] visit = new boolean[3]; //방문체크
	static ArrayList<Long> nums = new ArrayList<Long>(); //주어진 숫자 담기
	static ArrayList<Character> ops = new ArrayList<Character>(); //주어진 문자 담기
	static long answer; // 답
	
	public long solution(String expression) {
		answer =0;
		
		String num = "";
		for(int i=0; i<expression.length(); i++) {
			if(expression.charAt(i) >= '0' && expression.charAt(i) <='9') {
				num += expression.charAt(i);
			}else {
				nums.add(Long.parseLong(num));
				num = "";
				ops.add(expression.charAt(i));
			}
		}
		//마지막 숫자
		nums.add(Long.parseLong(num));
		
		dfs(0);
		
		return answer;
	}
	
	public void dfs(int start) {
		if(start == 3) {
			//연산자 3개 모두 사용하면 math를 실행한다 모든 조합에 대입 그 중 가장 큰 값을 찾는다
			/*
			 * + - *
			 * + * -
			 * - + *
			 * - * +
			 * * + -
			 * * - +
			 */
			
			math();
		}else { //연산자 모두 사용하지 않았다면 3개 모두 사용할 때 까지 반복
			for(int i=0; i<3; i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[start] = cal[i];
					dfs(start+1);
					visit[i] = false;
				}
			}
		}
	}
	
	public void math() {
		//주어진 숫자와 연산 그대로 복사
		ArrayList<Long> copyNums = new ArrayList<Long>(nums);
		ArrayList<Character> copyOps = new ArrayList<Character>(ops);
		
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<copyOps.size(); j++) {
				if(temp[i] == copyOps.get(j)) {
					//숫자 2개, 연산자 1개 보내서 연산
					Long res = calc(copyNums.remove(j), copyNums.remove(j), temp[i]);
					//연산 결과값 넣기
					copyNums.add(j , res);
					copyOps.remove(j);
					j--;
				}
			}
		}
		answer = Math.max(answer, Math.abs(copyNums.get(0)));
	}
	
	public static Long calc(Long num1, Long num2, char op) {
		switch(op) {
		case '+' :{
		return num1 + num2;
		}
		case '-' : {
			return num1 - num2;
		}
		case '*' : {
			return num1 * num2;
		}
	}
		return(long)0;
	}
}
