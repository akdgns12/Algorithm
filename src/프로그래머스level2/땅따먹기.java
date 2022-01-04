package 프로그래머스level2;
/*
 * 두 번째 행부터 위의 행을 더한 값을 비교하면서
 * MAX를 넣어주는 방식
 * 한 변수를 계속 사용하면 변수가 초기화되지 않을 수 있어 문제푸는데
 * 애먹을 수 있으니, 변수를 다른 곳에 저장해두고 어디서 초기화 시키는지도 
 * 생각할 필요가 있다.
 */

public class 땅따먹기 {
	int solution(int[][] land) {
		int answer = 0;
		
		for(int i=1;i<land.length; i++) { //행
			for(int j=0; j<=3; j++) { //열
				
				int a = land[i][j];
				
				for(int k=0; k<=3; k++) {
					if(j==k)
						continue;		
					else
						land[i][j] = Math.max(land[i][j], a + land[i-1][k]);
				}//for - k
			}//for - j - 4개의 숫자들이 자기자신의 위를 뺀 3번씩 더해서 max 찾기
		}//for -i
		
		for(int i=0; i<4; i++)
			answer = Math.max(answer, land[land.length-1][i]);
		
		return answer;
	}	
}
