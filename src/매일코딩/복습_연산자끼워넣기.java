package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 복습_연산자끼워넣기 {
	static int n;
	static int[] number;
	static int[] operator = new int[4]; // 0:덧셈, 1:뺼셈, 2:곱셈, 3:나눗셈
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		// 숫자 입력받기
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 갯수 정보 입력 받기
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
			// 연산자가 1개 이상인 경우
			if(operator[i] > 0) {
				
				// 해당 연산자를 감소 시킨다
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
				// 재귀 호출이 종료되면 다시 연산자 개수를 복구시킨다
				operator[i]++;
			}
		}
	}
}
