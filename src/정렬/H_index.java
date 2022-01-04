package 정렬;

import java.util.ArrayList;
import java.util.Arrays;

public class H_index {
	//논문 n편중 ,h번 이상 인용된 논문이 h편이상이고 
	// 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index
	//H-Index 리턴
	//논문의 인용 횟수를 담은 배열 citations
	public int solution(int[] citations) {
		int len = citations.length;
		Arrays.sort(citations);
		int max = 0;
		int cnt = 0;
		//오름차순 정렬해놓고, citations의 가장 큰원소까지 h증가시키며 반복
		for(int h=0; h<=citations[len-1]; h++) {
			//인용횟수 h보다 큰 인용문의 개수 찾기
			for(int i=0; i<len; i++) {
				if(h<=citations[i])
					cnt++;
			}
			
			//h보다 큰 인용문의 개수가 h이상이면 max값을 update
			if(cnt >= h)
				max = max < h ? h : max;
			cnt = 0; //cnt 초기화
		}
		
		return max;
	}
}
