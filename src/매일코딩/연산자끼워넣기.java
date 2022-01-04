package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class �����ڳ����ֱ� {
	static int[] number;
	static int[] operator = new int[4]; // 0:����, 1:����, 2:����, 3:������
	static int N;
	static int min = Integer.MAX_VALUE; // �ּڰ�
	static int max = Integer.MIN_VALUE; // �ִ�
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // ���� ����
		number = new int[N];	// ���� �迭
		
		// ���� �Է�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());	
		}
		
		// ������ �Է�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		// end of Input
		
		// dfs ȣ��
		dfs(number[0], 1); 
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int idx) {
		if(idx == N) { //dfs ���� ��, ������ �ε������� ���ȣ���� �����ϸ� �� �κп��� �ɸ���.
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// ������ ������ 1�� �̻��� ���
			if(operator[i] > 0) {
				
				// �ش� �����ڸ� 1 ���ҽ�Ų��.
				operator[i]--;
				
				switch(i) {
				case 0 : dfs(num + number[idx], idx + 1); 
					break;
				case 1 : dfs(num - number[idx], idx + 1);
					break;
				case 2 : dfs(num * number[idx], idx + 1);
					break;
				case 3 : dfs(num / number[idx], idx + 1);
					break;
				}
				// ��� ȣ����� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			}
		}
	}
}
