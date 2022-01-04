package 문자열;
import java.util.*;
//DP문제다....확실히 복습해서 내것으로 만들자

public class 문자열판별 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashSet<String>	 A = new HashSet<>();
		int[] dp = new int[101];
		
		String s = sc.nextLine();
		int N = sc.nextInt();
		
		//A의 문자열들 순서대로 입력받아 HashSet에 넣어준다
		for(int i=0; i<N; i++) {
			A.add(sc.nextLine());
		}
		/*
		 * 안쪽에 있는 반복문에서는 dp[1]인 경우를 찾아서 그 나머지 부분을 체크
		 * s.substring(i)인 부분 문자열 안에서 dp[j]가 1인 경우를 보면
		 * s.substring(j)가 A에 포함되어 있다는 의미고, 만약 s.substring(i,j)도
		 * A에 포함되어 있다면 dp[i]도 1이 되는 것임.
		 * 그리고 s.substring(i)이 친구 자체가 A에 포함되어 있는지 여부도 체크해준다.
		 * 정답은 dp[0](문자열 A들의 문자열로 이루어져 있는지 여부)를 출력
		 */
		//i = 문자열 s의 끝부터 처음까지
		for(int i=s.length()-1; i>=0; i--) {
			//j = i+1부터 문자열 s의 끝까지
			for(int j=i+1; j<s.length(); j++) {
				if(dp[j] == 1) {
					if(A.contains(s.substring(i,j))) dp[i]=1;
				}
			}
			if(A.contains(s.substring(i))) dp[i] = 1;
		}
		
		System.out.println(dp[0]);
	}
}
