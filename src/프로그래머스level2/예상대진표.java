package 프로그래머스level2;


public class 예상대진표 {
	public int solution(int n, int a, int b) {
		int answer = 1;
		/*
		 * 처음에 a와 b중 더 큰수를 오른쪽에 놓고 작은 수를 왼쪽에 놓는작업 진행
		 * 두 수의 차가 1이면 반복문 탈출조건
		 * 
		 */
		//직관적인 해답
		int left = 0;
		int right = 0;
		
		if( a > b) {
			left = b;
			right = a;
		}else {
			left = a;
			right = b;
		}
		
		while(true) {
			if(left % 2 !=0 && right - left == 1) {
				break;
			}
			
			left = (left + 1) / 2;
			right = (right + 1) / 2;
			answer++;
		}
		return answer;
	}
}
/*
 * 좀 더 고민해보면 간단하게 구현 가능
 * int answer = 0;
 * while(a !=b){ // a와 b가 같으면 정답
 *  a = (a+1) / 2;
 *  b = (b+1) / 2;
 *  answer++;
 */
*/