package �ϵ��ھ�͵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ���� {
	// BOJ 1166 ���� / �� 3
	// AxAxA�� ������ A�� �ִ�
	// �Է°� ���� 10���� �Ѿ..�̺�Ž��
	static long N;
	static long L,W,H;
	static double answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // �ڽ��� ����
		
		L = Integer.parseInt(st.nextToken()); // ���ʴ�� ������ü ����,����,����
		W = Integer .parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		// ã������ ������ü �ڽ��� �Ѻ� ���� = mid�� ������ �̺�Ž��
		double start = 0;
		double end;
		double A;
		
		end = Math.max(L, Math.max(W, H));
		for(int i=0; i<1000; i++) {
			A = (start + end) / 2;
			if((long)(L/A) * (long)(W / A) *
					(long)(H / A) >= N) // ū���ڿ� ���� �� ������ ���� >= N
				start = A;
			else end = A;
		}
		System.out.println(start);
	} 
}
