package NHN기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_빗물 {
	// BOJ 빗물 골드 5 / 시뮬? / 착상 조건이 까다로운 듯 쉬움;;
	static int H; // 세로 길이
	static int W; // 가로
	static int[] arr; // 인덱스 : 좌표, 값 : 높이
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		/*
		 * 인덱스를 탐색하면서
		 * 1. 해당 인덱스의 좌,우 최댓값을 각각 찾는다
		 * 2. 두 개의 값 중 MIN값을 구하고
		 * 3. MIN값보다 작아야 물이 고일 수 있다!
		 */
		// 처음과 끝은 기둥떄문에 어차피 빗물 고일 수 없으니까
		// 탐색범위 앞뒤로 하나씩 줄여도 된다.
		
		System.out.println(solution(arr, W));
	}
	
	public static int solution(int[] arr, int W) {
		int answer = 0;
		for(int i=1; i<W-1; i++) {
			// 왼쪽으로 탐색, 오른쪽으로 탐색 수행한 최댓값 각각 구한다.
			int leftMax = getLeftMax(arr, i);
			int rightMax = getRightMax(arr, i);
			
			// 두 개의 값 중 작은 값 구한다
			int height = Math.min(leftMax, rightMax);
			
			if(height > arr[i]) {
				answer += height - arr[i];
			}
		}
		
		return answer;
	}
	
	public static int getLeftMax(int[] arr, int i) {
		int result = 0;
		for(int idx = i-1; i>=0; i--) {
			result = Math.max(result, arr[i]);
		}
		return result;
	}
	
	public static int getRightMax(int[] arr, int i) {
		int result = 0;
		for(int idx = i+1; i<arr.length; i++) {
			result = Math.max(result, arr[i]);
		}
		return result;
	}
}
