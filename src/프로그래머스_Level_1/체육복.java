package 프로그래머스_Level_1;

import java.util.Arrays;

/*
 * 전체 학생의 수 n
 * 체육복을 도난당한 학생들의 번호가 담긴 배열 lost
 * 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserver
 * 체육수업을 들을 수 있는 학생의 최댓값을 return
 */
/*
 * 
 */
public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//여벌 체육복을 가져온 학생이 도난당한 경우
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i] == reserve[j]) {
				answer++;
				lost[i] = -1;
				reserve[j] = -1;
				break;
			}
		}
		}
		//도난당한 학생에게 체육복을 빌려주는 경우
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length; j++) {
				if(lost[i]-1 == reserve[j] || lost[i] + 1 == reserve[j] {
					answer++;
					reserve[j] = -1;
					break;
				})
			}
		}
		return answer;
	}
}
