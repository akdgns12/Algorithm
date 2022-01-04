package 프로그래머스level2;
/*
 * 점프 
 * 순간이동 = 현재까지 이동거리 *2
 * 점프할 땐 배터리 사용량 거리에 비례해 늘어남
 * 순간이동일 땐 배터리 사용안됨
 * 건전지 사용량 가장적은 경우 return
 * 
 */
// top_down방식을 생각하면 금방 풀림
public class 점프와순간이동 {
	public int solution(int n) {
		int answer = 0;
		
		//1.n이 이 될때까지
		//2. n이 홀수일 때와 짝수일 때
		while(n !=0) {
			if(n%2 == 0) {
				n /= 2;
			}else {
				n--;
				answer++;
			}
		}
		
		
		
		return answer;
	}
}
