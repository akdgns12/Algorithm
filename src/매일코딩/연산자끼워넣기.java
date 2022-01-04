package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	static int[] number;
	static int[] operator = new int[4]; // 0:덧셈, 1:뺄셈, 2:곱셈, 3:나눗셈
	static int N;
	static int min = Integer.MAX_VALUE; // 최솟값
	static int max = Integer.MIN_VALUE; // 최댓값
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 수의 개수
		number = new int[N];	// 숫자 배열
		
		// 숫자 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());	
		}
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		// end of Input
		
		// dfs 호출
		dfs(number[0], 1); 
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int idx) {
		if(idx == N) { //dfs 종료 부, 마지막 인덱스에서 재귀호출을 실행하면 이 부분에서 걸린다.
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			// 연산자 개수가 1개 이상인 경우
			if(operator[i] > 0) {
				
				// 해당 연산자를 1 감소시킨다.
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
				// 재귀 호출들이 종료되면 다시 해당 연산자 개수를 복구한다.
				operator[i]++;
			}
		}
	}
}
