package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2526번 싸이클
public class BOJ2526 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1[] = br.readLine().split(" "); 
		int N = Integer.parseInt(str1[0]);
		
		int P = Integer.parseInt(str1[1]);  // str[1] 문자열을 숫자로 변환시키는 방법
		
		int idx = 0;  // idx 초기값은 0
		int temp = N; // temp 초기값은 N
		int arr[] = new int[P+1]; //크기가 P+1인 arr배열
		boolean isFound = false;
		while(!isFound) { // 
			temp = N * temp % P;  //문제 공식
			for(int i = 0; i<idx; i++) {
				if(arr[i]==temp) {
				isFound = true;
				bw.write(String.valueOf(idx - i));
				break;
				}
			}
			arr[idx] = temp;
			idx++;
		}
		bw.flush();
	}
}