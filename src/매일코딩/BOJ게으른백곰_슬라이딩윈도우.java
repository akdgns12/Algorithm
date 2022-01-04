package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ���������_�����̵������� {
		// BOJ / 10025�� / ������ ��� / �����̵� ������ / �ǹ�4
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
			int n = Integer.parseInt(stk.nextToken());
			int k = Integer.parseInt(stk.nextToken());
		
			int arr[] = new int[1000001];
		
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
		
				int w = Integer.parseInt(stk.nextToken());
				int p = Integer.parseInt(stk.nextToken());
				
				arr[p] = w;
		}
			
		int sum = 0;
		int max = 0;
		int window = 1 +(2*k);
		boolean flag = false;
		
			for(int i=0; i<=1000000; i++) {
		// �ʹ� k-1���� �������� sum�� max�� ���ϸ�ȵ�.
				if(i == window-1) flag = true;
				if(i >= window) {
					sum -= arr[i-window];
			}
				sum += arr[i];
				if(sum > max && flag) {
					max = sum;
				}
			}
			System.out.println(max);
			}
		}