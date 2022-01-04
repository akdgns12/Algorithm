package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_�����ڳ����ֱ� {
	static int n;
	static int[] number;
	static int[] operator = new int[4]; // 0:����, 1:�E��, 2:����, 3:������
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		// ���� �Է¹ޱ�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// ������ ���� ���� �Է� �ޱ�
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		} // end of Input
		
		dfs(number[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int idx) {
		if(idx == n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// �����ڰ� 1�� �̻��� ���
			if(operator[i] > 0) {
				
				// �ش� �����ڸ� ���� ��Ų��
				operator[i]--;
				
				switch(i) {
				case 0: dfs(num + number[idx], idx+1); 
					break;
				case 1: dfs(num - number[idx], idx+1);
					break;
				case 2: dfs(num * number[idx], idx+1);
					break;
				case 3: dfs(num / number[idx], idx+1);
					break;
				}
				// ��� ȣ���� ����Ǹ� �ٽ� ������ ������ ������Ų��
				operator[i]++;
			}
		}
	}
}
