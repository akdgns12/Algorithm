package ��������;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ����� {
	// BOJ_16472 / ��3 / �� ������
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
			// 1. N���� + 1���� end�ø��鼭 len ������
			while(end < s.length() && kindCnt <= N) {
				int cur = s.charAt(end++) - 'a';
				if(cnt[cur] == 0) kindCnt++;
				cnt[cur]++;
				len++;
				// N+1������ ���� len�� �����ϸ� �ȵȴ�
				if(kindCnt <= N) maxLen = Math.max(maxLen, len);
			}
			
			// 2. N���ڱ��� st���̱�
			
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
