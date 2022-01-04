package ���α׷��ӽ�level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/*
 * �־��� ��������� ��� ���ڿ� expression�� ������
 * ���Ƿ� �����Ͽ� ������ ���� ū �ݾ��� return
 * 
 */
// ���� ����� ����
// �����������³� ��ƴ� ����
/*
 * 1. ����Ž���� �̿��� ������ ��� ������ �����ش�.
 * 2. ���� ���� �� ������ ������ �´� ��츦 �߰��ϸ� �յ� ���ڿ� �������� ����� �� �ٽ� list�� �־��ش�.
 * 3. 2���� �ݺ��� �� �� ū���� ���Ѵ�.
 */
// 1. -,+,* ���� �ɷ��ش�
public class �����ִ�ȭ {
	static char[] cal = {'+','-','*'};// ���տ� ���
	static char[] temp = new char[3]; //��� ����
	static boolean[] visit = new boolean[3]; //�湮üũ
	static ArrayList<Long> nums = new ArrayList<Long>(); //�־��� ���� ���
	static ArrayList<Character> ops = new ArrayList<Character>(); //�־��� ���� ���
	static long answer; // ��
	
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
		//������ ����
		nums.add(Long.parseLong(num));
		
		dfs(0);
		
		return answer;
	}
	
	public void dfs(int start) {
		if(start == 3) {
			//������ 3�� ��� ����ϸ� math�� �����Ѵ� ��� ���տ� ���� �� �� ���� ū ���� ã�´�
			/*
			 * + - *
			 * + * -
			 * - + *
			 * - * +
			 * * + -
			 * * - +
			 */
			
			math();
		}else { //������ ��� ������� �ʾҴٸ� 3�� ��� ����� �� ���� �ݺ�
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
		//�־��� ���ڿ� ���� �״�� ����
		ArrayList<Long> copyNums = new ArrayList<Long>(nums);
		ArrayList<Character> copyOps = new ArrayList<Character>(ops);
		
		for(int i=0; i<temp.length; i++) {
			for(int j=0; j<copyOps.size(); j++) {
				if(temp[i] == copyOps.get(j)) {
					//���� 2��, ������ 1�� ������ ����
					Long res = calc(copyNums.remove(j), copyNums.remove(j), temp[i]);
					//���� ����� �ֱ�
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
