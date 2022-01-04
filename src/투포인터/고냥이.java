package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 고냥이 {
	// BOJ_16472 / 골3 / 투 포인터
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		int maxLen = 0;
		int len = 0;
		int[] cnt = new int[26];
		int kindCnt = 0;
		
		int st = 0, end = 0;
		
		while(st <= end && end < s.length()){
			// 1. N글자 + 1까지 end늘리면서 len 비교저장
			while(end < s.length() && kindCnt <= N) {
				int cur = s.charAt(end++) - 'a';
				if(cnt[cur] == 0) kindCnt++;
				cnt[cur]++;
				len++;
				// N+1글자일 때는 len을 갱신하면 안된다
				if(kindCnt <= N) maxLen = Math.max(maxLen, len);
			}
			
			// 2. N글자까지 st줄이기
			
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
