package īī������;
import java.util.*;

public class ��ȣ��ȯ {
	//�ùٸ� ��ȣ���� �ƴ��� üũ�ϴ� �Լ�
	int pos;
	boolean isCorrect(String str) {
		boolean ret = true;
		int open = 0, close = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '(') {
				open++;
				stack.push('(');
			}else {
				close++;
				//������ ����ִٸ� ¦�� �ȸ´� ���ϱ� �ùٸ� ��ȣ x
				if(stack.isEmpty()) 
					ret = false;
				else
					stack.pop();
			}
			if(open == close) {
				pos = i+1;
				return ret;
			}
		}
		
		return true;
	}
	
	public String solution(String p) {
	//1.�� ���ڿ��� ��� �� ���ڿ� ��ȯ
		if(p.equals(""))
		return "";
	
	boolean correct = isCorrect(p);
	String u = p.substring(0, pos);
	String v = p.substring(pos, p.length());
	
	if(correct) {
		return u + solution(v);
	}
	
	String answer ="(" + solution(v) + ")";
	//1���� ���� , length()-1 �ؼ� ù,�� ���� ����
	for(int i=1; i<u.length()-1; i++) {
		if(u.charAt(i) == '(')
			answer += ")";
		else
			answer += "(";
	}
	
	return answer;
	}
}
