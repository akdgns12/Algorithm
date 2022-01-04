package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 좋다 {
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
		
		for(int i=0; i<N; i++) {
			int left = 0, right = N-1;
			int target = arr[i];
			while(left < right) {
				int sum = arr[left] + arr[right];
				if(sum < target) {
					left++;
				}else if(sum > target) {
					right--;
				}else {
					if(i != left && i != right) { // 자기자신이 되면 안되니까
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
