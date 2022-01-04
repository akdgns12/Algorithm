package ���α׷��ӽ�_Level_1;

import java.util.Stack;
/*
 * <����>
 * 1.�ٱ��� ������ ���� stack�� �غ��ϰ�, 0�� �ִ´�
 *  0�� �ִ� ������ stack�� �� �� ���� ���ؾ��ϴµ� �ƹ��͵� ������ ������
 * 2.moves�� ���̸�ŭ for���� ������
 * board�� ���̸�ŭ for���� ������(�ش� ���ο��� ������ �̱� ����)
 * ���� board[j][move-1]�� 0�̶�� ������ ���� ���̱� ������ �Ѿ��
 * 0�� �ƴ϶�� 
 * stack(�ٱ���)�� ���� �� ��ҿ� board[j][moves-1]�� ������ ��
 * ���ٸ� ������ ������ ���̱� ������ stack���� pop���ְ� answer�� 2�� ���Ѵ�
 * �ٸ��ٸ� stack�� board[j][moves-1]�� push�Ѵ�.
 * 3. answer�� ����
 */
public class ũ���������̱�_���� {
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

