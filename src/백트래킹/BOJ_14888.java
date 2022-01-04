package ��Ʈ��ŷ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	// ������ �����ֱ� / ��Ʈ��ŷ / �ǹ� 1
	static int N;
	static int[] number;
	static int[] operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<operator.length; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(number[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		
	}	
	
	public static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// ������ ������ 1�� �̻��� ���
			if(operator[i] > 0) {
				// �ش� �����ڸ� 1 ����
				operator[i]--;
				
				switch(i) {
				case 0:
					dfs(num + number[idx], idx+1); 
					break;
				case 1:
					dfs(num - number[idx], idx+1);
					break;
				case 2:
					dfs(num * number[idx], idx+1);
					break;
				case 3:
					dfs(num / number[idx], idx+1);
					break;
				}
				// ���ȣ���� ����Ǹ� �ٽ� �ش� ������ ������ �����Ѵ�.
				operator[i]++;
			} // end if
		} // end for
	}
}
