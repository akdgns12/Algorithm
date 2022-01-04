package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ����_���� {
	static int H;
	static int W;
	static int[] arr;
	
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
		

		System.out.println(solution(arr, W));
	}
	
	// �������� Ž�� �ִ�, ���������� Ž�� �ִ� ���� ���Ѵ�
	public static int solution(int[] arr, int W) {
		int answer = 0;
		for(int i=1; i<W-1; i++) {
			int leftMax = getLeftMax(arr, i);
			int rightMax = getRightMax(arr, i);
			
			int height = Math.min(leftMax, rightMax);
			
			if(height > arr[i]) {
				answer += height - arr[i];
			}
		}
		return answer;
	}
	
	// �����ε������� �������� Ž�� �� �ִ� ã��
	public static int getLeftMax(int[] arr, int i) {
		int result = 0;
		for(int idx = i-1; idx >= 0; idx--) {
			result = Math.max(result, arr[i]);
		}
		return result;
	}
	// �����ε������� ���������� Ž�� �� �ִ� ã��
	public static int getRightMax(int[] arr, int i) {
		int result = 0;
		for(int idx = i+1; i<arr.length; idx++) {
			result = Math.max(result, arr[i]);
		}
		return result;
	}
}
