package 프로그래머스level2;

import java.util.Arrays;

/*
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표.
 * 어느 과학자의 H-Index를 나타내는 값인 h를 구하려 한다.
 * 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이
 * h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index.
 * 논문의 인용 횟수를 담은 배열 citations
 * H-Index를 return하라 
 */
public class H_Index {
	public int solution(int[] citations) {
		int answer = 0;
		
		int len = citations.length;
		Arrays.sort(citations);
		int max = 0;
		int cnt = 0;
		
		for(int h=0; h<citations[len-1]; h++) {
			//인용횟수 h보다 큰 인용문의 개수 찾기
			for(int j=0; j<len; j++) {
				if(h<=citations[j])
					cnt++;
			}
			//h보다 큰 인용문의 개수가 h이상이면 max값을 update
			if(cnt >=h)
				max = max < h ? h : max;
			cnt = 0; // cnt 초기화
			
		}
		
		
		answer = max;
		
		return answer;
	}
}
