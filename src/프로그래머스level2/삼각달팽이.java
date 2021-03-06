package 프로그래머스level2;
/*
 * 2019카카오 공채 기출
 */
public class 삼각달팽이 {
	public int[] solution(int n) {
		int[] answer = new int[(n* (n+1))/2];
        // n번   내려가기 / n-1번 옆으로가기 / n-2번 올라가기
        // n-3번 내려가기 / n-4번 옆으로가기 / n-5번 올라가기...
        // n-n번이 될때까지
		// 각 단계별로 값(val)은 1씩 증가
		// 갑승ㄹ 입력할 위치(idx)는 방향에 따라 달라짐(Down-> 특정값(cnt)더하기 / Side -> 1 더하기 / Up -> 특정값(cnt) 빼기) 
        int val = 1; int idx = 0; int cnt = 0;
        int stg = 0; // 0 Down 1 Side 2 Up
        int stg_n = n;
        
        while(n>0){
            // Down
            if(stg == 0){
                idx = idx + cnt;
                answer[idx] = val++;
                cnt++;
                stg_n--;
                // Down -> Side
                if(stg_n == 0){
                    stg = 1; // Side
                    stg_n = --n;
                }
            }
            // Side
            else if(stg == 1){
                answer[++idx] = val++;
                stg_n--;
                // Side -> Up
                if(stg_n == 0){
                    stg = 2; // Up
                    stg_n = --n;
                }
            }
            // Up
            else{
                idx = idx - cnt;
                answer[idx] = val++;
                cnt--;
                stg_n--;
                // Up -> Down
                if(stg_n == 0){
                    stg = 0; // Down
                    stg_n = --n;
                }
            }
        }
		
		return answer;
	}
}
