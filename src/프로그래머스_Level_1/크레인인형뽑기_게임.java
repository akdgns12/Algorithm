package 프로그래머스_Level_1;

import java.util.Stack;
/*
 * <착상>
 * 1.바구니 역할을 해줄 stack을 준비하고, 0을 넣는다
 *  0을 넣는 이유는 stack의 맨 위 값과 비교해야하는데 아무것도 없으면 오류남
 * 2.moves의 길이만큼 for문을 돌린다
 * board의 길이만큼 for문을 돌린다(해당 라인에서 인형을 뽑기 위해)
 * 만약 board[j][move-1]이 0이라면 인형이 없는 것이기 때문에 넘어간다
 * 0이 아니라면 
 * stack(바구니)의 가장 윗 요소와 board[j][moves-1]가 같은지 비교
 * 같다면 인형이 터지는 것이기 때문에 stack에서 pop해주고 answer에 2를 더한다
 * 다르다면 stack에 board[j][moves-1]을 push한다.
 * 3. answer를 리턴
 */
public class 크레인인형뽑기_게임 {
	public int solution(int[][] board, int[] moves	) {
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<moves.length; i++){
			for(int j=0; j<board.length; j++) {
				if(board[j][moves[i]-1]!=0) {
					if(stack.isEmpty()) {
						stack.push(board[j][moves[i]-1]);
					}else {
						if(stack.peek() == board[j][moves[i]-1]) {
							stack.pop();
							answer +=2;
						}else {
							stack.push(board[j][moves[i]-1]);
						}
					}
					board[j][moves[i]-1] = 0;
					break;
				}
				
			}
		}
		return answer;
	}
}

