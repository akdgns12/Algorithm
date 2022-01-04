package NHN����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_���� {
	// BOJ ���� ��� 5 / �ù�? / ���� ������ ��ٷο� �� ����;;
	static int H; // ���� ����
	static int W; // ����
	static int[] arr; // �ε��� : ��ǥ, �� : ����
	
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
		 * �ε����� Ž���ϸ鼭
		 * 1. �ش� �ε����� ��,�� �ִ��� ���� ã�´�
		 * 2. �� ���� �� �� MIN���� ���ϰ�
		 * 3. MIN������ �۾ƾ� ���� ���� �� �ִ�!
		 */
		// ó���� ���� ��Ջ����� ������ ���� ���� �� �����ϱ�
		// Ž������ �յڷ� �ϳ��� �ٿ��� �ȴ�.
		
		System.out.println(solution(arr, W));
	}
	
	public static int solution(int[] arr, int W) {
		int answer = 0;
		for(int i=1; i<W-1; i++) {
			// �������� Ž��, ���������� Ž�� ������ �ִ� ���� ���Ѵ�.
			int leftMax = getLeftMax(arr, i);
			int rightMax = getRightMax(arr, i);
			
			// �� ���� �� �� ���� �� ���Ѵ�
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
