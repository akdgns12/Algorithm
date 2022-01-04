package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_더하기사이클 {
/*
 * 주어진 수 n < 10 이면 앞에 0을 붙여 두자리 수 만든 후, 각 자리의 숫자를 더함
 * 주어준 수 n의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면
 * 새로운 수를 만들 수 있음.
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int copy = n;
		
		do {
			n = ((n%10)*10) + ((n/10) + (n%10)%10);
			cnt++;
		}while(copy != n);
		
		System.out.println(cnt);
	}

}
