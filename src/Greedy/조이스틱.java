package Greedy;

public class ���̽�ƽ {
	public int solution(String name) {
		int len = name.length();
		//ó������ ������ ���������� �� ���� �̵�Ƚ��
		int min_move = len - 1;
		
		int answer = 0;
		
		for(int i=0; i<name.length(); i++) {
			
			if(name.charAt(i) <= 'M') {
				answer += name.charAt(i) - 'A';
			}else {
				answer += 'Z' - name.charAt(i) + 1;
			}
			
			//2.�¿� : ���ӵ� A�� ���忡 ���� �޶����� �ּ� ������
			int next = i + 1;
			while(next < len && name.charAt(next) == 'A') {
				next++;
			}
			min_move = Math.min(min_move, i+len-next+Math.min(i, len-next));
			// len - next : 
						// �� ���̿��� ���� �ٷ� ������ ���ӵ� A�� ������ ���� ���� ����
						// i : ������������ ��������� �̵�Ƚ��
						// i + len - next + i : ������� �Դٰ� �ٽ� ���ư��� ���� �� ���� ���� �̵� Ƚ��
						// min(i,len-next)����,
						// i ���� len-next ���� ���� ��쿡 len-next�� �����ϴµ�
						// �̴�, ������ ���ڰ� A�� ��츦 ���� �ϸ�
						// ������ len-1 ���� ũ�� �ȴ� (len-next >=1)
						// ����,i�� len-next(���� ����)���� ū ����
						// ���� �������� �ٽ� ���ư� �ʿ䰡 ����.
						// ��� ���� A�� ����, len-next�� 0�� �ǹǷ�,
						// ������ len-1 ���� ���� i �� �ּ� �̵�Ƚ���� �ȴ�.
						// ���� Math.min(i,len-next) �� �κ��� �Ŀ��� �ʿ��ϰ� �ȴ�.
						
		}
		
		answer += min_move;
		return answer;
	}
}
