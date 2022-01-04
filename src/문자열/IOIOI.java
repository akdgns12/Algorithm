package 문자열;

import java.util.Scanner;

public class IOIOI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 정해진 패턴을 찾는 문자열 매칭 알고리즘
		 * Pn은 IOI가 N개 만큼 반복되는 형태이기 때문에, for문을 사용해
		 * 일일히 IOI패턴을 찾아 횟수를 센 후 N과 비교하는 방식으로 진행
		 * 시간복잡도 O(n)
		 * 
		 * 설명
		 * Pn은 IOI가 N개만큼 반복되는 형태
		 * 즉, 각 index를 비교해 IOI패턴을 만족하는지 확인하고 연속된
		 * 횟수를 센 후, N과 일치할 경우 결과 값을 1늘려주면 된다
		 * 여기서 패턴을 만족할 경우 행해야 할 행동들
		 * 1. 패턴 연속횟수를 1 줄인다.
		 *  - IOI가 연속된 긴 패턴의 경우 Pn이 연속으로 나타나기 때문에
		 * 2. 2칸 뒤로 이동해 패턴이 연속되는지 확인한다.
		 *  - 나의 경우 자신이 0이고, 앞,뒤가 I일때 패턴을 만족한다는 조건이므로
		 */
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] c = sc.next().toCharArray();
		
		int result = 0;
		int patternCnt = 0;
		for(int i=1; i<m-1; i++) {
			if(c[i-1] == 'I' && c[i] == 'O' && c[i+1] == 'I') {
				patternCnt++;
				if(patternCnt == n) {
					patternCnt--;
					result++;
				}
				i++;
			}else patternCnt = 0;
		}
		System.out.println(result);
	}
}
