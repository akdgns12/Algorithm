package 프로그래머스level2;
/*
 * 자연수 n을 역속한 자연수들로 표현하는 방법의 수 return
 * 
 */
public class 숫자의표현 {
	public int solution(int n) {
		int answer = 0;

		for(int i=1; i<=n; i++){
            int sum = 0;
            for(int j=i; j<=n; j++){
                sum += j;
                
                if(sum == n){
                    answer++;
                    break;
                }else if(sum > n){
                    break;
                }
            }
        }
		
		
		return answer;
	}
}
