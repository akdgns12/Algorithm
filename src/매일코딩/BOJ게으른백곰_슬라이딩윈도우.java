package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ게으른백곰_슬라이딩윈도우 {
		// BOJ / 10025번 / 게으른 백곰 / 슬라이딩 윈도우 / 실버4
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
		// 초반 k-1범위 전까지는 sum을 max랑 비교하면안됨.
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