package ���α׷��ӽ�level2;
/*
 * JadenCase�� ��� �ܾ��� ù ���ڰ� �빮���̰�, �� ���� ���ĺ��� �ҹ���
 * �־��� ���ڿ� s �� JadenCase�� �ٲ� ���ڿ��� return�ϴ� solution
 * 
 */
// ���ڿ��� �������� �����ϰų� ������ 2�������ų� �������� ������ ������ ��쵵
// �����ؾ� �Ѵ�!
public class JadenCase���ڿ������ {
	public String solution(String s) {
		String answer = "";
		// �ҹ��ڷ� �ٲٰ� �ѹ��ھ� String�迭�� ���
		String[] sp = s.toLowerCase().split("");
		boolean flag = true; //���� ���ڰ� ���ڿ��� �� �տ� �ִ� �������� �Ǻ�
		
		for(String ss : sp) {
			answer += flag ? ss.toUpperCase() : ss;
			flag = ss.equals(" ") ? true : false;
		}
		//s�� ��� �ҹ��ڷ� �ٲ� �� �� ���ھ� String�迭�� ��´�
		// flag�� ���� ���ڰ� ���ڿ��� �� �տ� �ִ� �������� �Ǻ� ��,
		// ���� ��� �빮�ڷ� �������ش�
		// ���ڸ� �Ѱ��� �ڸ��ϱ� ���鵵 �״�� ���� ������ ���� ���� ó����
		// ������ �ʾƵ� �ȴ�.
		
		
		
		return answer;
	}
}
