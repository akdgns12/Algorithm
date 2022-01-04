package 프로그래머스_Level_1;
/*
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려 한다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 
 * 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return하도록
 * solution함수를 완성하라.
 */
//n이 소수인지 판별하기 위해서는 2~n-1까지 모든 수로 나눠볼 필요없이 
//루트 n까지만 나눠보면 된다.
public class 소수만들기 {
	public boolean isPrime(int n) {
		for(int i=2; i+i<=n; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public int solution(int[] nums) {
		int answer = 0;
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					if(isPrime(sum)) answer++;
				}
			}
		}
		return answer;
	}
}
