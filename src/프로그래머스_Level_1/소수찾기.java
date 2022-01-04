package 프로그래머스_Level_1;
/*
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution
 * 소수는 1과 자기자신으로만 나누어지는 수
 * (1은 소수가 아님)
 */
// 변수 2개 사용한 풀이
/*
public class 소수찾기 {
	public int solution(int n) {
		int answer = 0;
		int count = 0; //소수 판별 변수
		int primeNum = 1; //소수개수 반환변수
		
		for(int i=3; i<=n; i++) {//3부터 n까지
			for(int j=2; j<i; j++) {
				if(i%j==0)
					count++;
			}
			if(count==0)
				primeNum++;
			count = 0;
		}
		
		return answer = primeNum;
	}
}
*/
/*
 * 변수 하나 사용한 풀이
 * class Solution {
  public int solution(int n) {
      int answer = 1;
      int count =0;//소수판별 변수
     
      for(int i=3; i<=n;i++){//3부터 n까지
         for(int j=2; j<i; j++){
              if(i%j==0)
                  count++;
            }
          if(count==0)
                answer++;
          count=0;
      }
           return answer;
  }
}
 */
/*
 * 에라토스테네스의 체 사용한 풀이
 * 에라토스테네스 원리
 * 1. 자신의 값의 루트 값을 구한다
 * 2. 2부터 루트 값 사이의 수들의 배수들을 다 없앤다
 * 3. 그리고 나머지는 소수
 * */
 class Solution {
  public int solution(int n) {
      int answer = 0;
      boolean[] sosu =new boolean [n+1];
      
      for(int i=2; i<=n ; i++)
          sosu[i]=true;
       
      int root=(int)Math.sqrt(n);
      
     for(int i=2; i<=root; i++){
         if(sosu[i]==true){
             for(int j=i; i*j<=n; j++)
                    sosu[i*j]=false;
         }      
     }
      for(int i =2; i<=n; i++)  { 
          if(sosu[i]==true)
          answer++;
      }
      return answer;
  }
}

