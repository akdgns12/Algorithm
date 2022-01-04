package 프로그래머스level2;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 기능개선 작업.
 * 각 기능은 진도가 100%일 때 서비스에 반영가능
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다
 * 먼저 개발될 수 있고, 이 떄 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포.
 * 먼저 배포되어야 하는 순섣로 작업의 진도가 적힌 정수배열 progresses와 각 작업의
 * 개발 속도가 적힌 정수배열 speeds가 주어질 때, 각 배포마다 몇 개의 기능이 배포되는지를
 * return 하는 함수 solution
 */
//앞에있는 progresses가 완료되어야 배포 가능
// 1. 주어진 배열을 이용 해 각각의 작업이 완료되는 시간을 stack으로 만들어 저장
// 2. stack 맨 위(제일 처음해야하는 작업)을 pop으로 추출하여 top에 저장하고
// 다음으로 오는 stack.peek() 값이 해당 값보다 작다면 이미 작업이 끝났다는 의미
// 이므로 카운팅. 3. 카운팅한 값들은 s라는 list에 차례대로 저장하뎌 정답 배열로 변환
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//각각의 작업이 완료되는 시간을 stack에 저장
		for(int i= progresses.length - 1; i >=0; i--) 
			stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0)); 
		
		ArrayList<Integer> s = new ArrayList<>();
		
		while(!stack.isEmpty()) { // 제일 첫 작업을 pop해서 top에 저장하고 다음 작업이 top보다 작다면 다음 작업은 이미 끝난 상태 
			int cnt = 1;          // 그러므로 cnt++ 해주고 다음작업도 pop해준다.
			
			int top = stack.pop();
			
			while(!stack.isEmpty() && stack.peek() <= top) {
				cnt++;
				stack.pop();
			}
			
			s.add(cnt);
		}
		
		int[] answer = new int[s.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = s.get(i);
		}
		
		return answer;
	}
}
