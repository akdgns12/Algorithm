package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 2526�� ����Ŭ
public class BOJ2526 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1[] = br.readLine().split(" "); 
		int N = Integer.parseInt(str1[0]);
		
		int P = Integer.parseInt(str1[1]);  // str[1] ���ڿ��� ���ڷ� ��ȯ��Ű�� ���
		
		int idx = 0;  // idx �ʱⰪ�� 0
		int temp = N; // temp �ʱⰪ�� N
		int arr[] = new int[P+1]; //ũ�Ⱑ P+1�� arr�迭
		boolean isFound = false;
		while(!isFound) { // 
			temp = N * temp % P;  //���� ����
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