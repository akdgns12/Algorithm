package ���α׷��ӽ�level3;

public class _2xNŸ�ϸ� {
	public int solution(int n) {
		int answer = 1;
		//dp����
		
		int a = 1;
		int b = 1;
		
		for(int i=1; i<n; i++) {
			int c = (a + b) % 1000000007;
			
			a = b;
			b = c;
		}
		return answer;
	}
}
