package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 복습3_고냥이 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int[] cnt = new int[26];
		int st = 0, end = 0;
		int maxLen = 0;
		int len = 0; // 만들어지는 문자열의 길이
		int kindCnt = 0; // 만들어지는 문자열 안의 문자 종류 개수
		
		while(st <= end && end < s.length()) {
			// 1. N+1까지 end늘려주기
			while(end < s.length() && kindCnt <= N) {
				int cur = s.charAt(end++) - 'a';
				if(cnt[cur] == 0) kindCnt++;
				cnt[cur]++;
				len++;
				// end가 N+1일때도 갱신해주면 안되기 때문에 필요함
				if(kindCnt <= N) maxLen = Math.max(maxLen, len);
			}
			
			while(st <= end && kindCnt > N) {
				int cur = s.charAt(st++) - 'a';
				cnt[cur]--;
				if(cnt[cur] == 0) kindCnt--;
				len--;
			}
		}
		System.out.println(maxLen);
	}

}
