package �ؽ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ���� {
	static int N;
	static int[] arr;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr); // �̺�Ž���� ���� �ʼ�
		for(int i=0; i<N; i++) { // �� ���� ���Ͽ�
			int left = 0, right = N-1;
			int target = arr[i];
			while(left < right) {
				int sum = arr[left] + arr[right];
				if(sum < target) {
					left++;
				}else if(sum > target) {
					right--;
				}else {
					if(i != left && i != right) { // �� ���� �ڽŰ� ������ �ȵǱ� ������
						answer++;
						break;
					}
					if(left == i) 
						left++;
					if(right == i)
						right--;
				}
			}
		}
		
		System.out.println(answer);
	}

}
