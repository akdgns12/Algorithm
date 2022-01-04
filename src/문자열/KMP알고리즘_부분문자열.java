package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *  pi배열 생성 과정
 *  j는 접두사의 위치, i는 접미사의 위치
 *  기본적인 동작과정 - j와i가 일치했을 경우와 j와 i가 일치하지 않았을 때의 경우를 나눠서 생각해봐야 한다.
 *  
 *  - j 위치의 문자열과 i 위치의 문자열이 일치했을 경우 : 그 위치에서 접두사와 접미사가 일치했다는 것이므로
 *  다음 위치의 j와 i의 문자열도 일치하는지 검사해야 한다. 따라서 j와 i의 위치를 한칸씩 오른쪽으로 이동해준다
 *  - j 위치의 문자열과 i위치의 문자열이 일치하지 않을 경우 : 접두사와 접미사가 일치하지 않는다는 것이므로
 *  다시 검사를 해야하는데 이때 아예 처음으로 돌아갈 수도 있으나 비효율적이다. 그래서 여태까지 일치했던 곳에서부터
 *  다시 검사를 하는 것이 유리합니다. 따라서 pi배열을 참고하여 j의 위치를 pi[j-1]에서 가리키는 위치로 이동 시켜봅니다.
 *  j-1인 이유는 최소 j-1위치까지는 접두사와 접미사가 일치했다는 것이므로 이동을 최소화할 수 있기 때문입니다. 이동을 시킨 후 
 *  다시 일치하는지 검사한다.
 *   */
/*
 * KMP 알고리즘 활용문제
 * -KMP알고리즘이란
 * 시간복잡도는 O(N+M)으로 브루트포스 O(NM)보다 매우 빠름
 * 접두사와 접미사를 알아야함.
 * 
 * origin의 문자열은 i를 통해 문자를 가리키고, pattern의 문자열은 j를 통해 문자를 가리킨다
 * origin[i] == pattern[j]이면 i와 j 모두 1씩 더한다
 * 일치하지 않고 j가 0이 아니라면 j = pi[j-1]을 통해 그 이전의 문자로 돌아간다(직전 문자에서 접미사와 접두사가 일치했던 부분까지
 * 일치하지 않고 j가 0이라면 i만 1을 더한다.
 * ex)
 * <banana의 접두사>



b

ba

ban

bana

banan

banana



이 6개가 banana의 접두사(prefix) 입니다.



<banana의 접미사>

a

na

ana

nana

anana

banana



이 6개가 banana의 접미사(suffix) 입니다.

두번째로 pi배열입니다.
pi[i]는 주어진 문자열의 0~i까지의 부분 문자열 중에서 prefix == suffix가 될 수 있는
부분 문자열 중에서 가장 긴 것의 길이 (이 때 prefix가 0~i까지의 부분 문자열과 같으면 안된다.)



출처: https://bowbowbow.tistory.com/6 [멍멍멍]
 */
// 기본 알고리즘 코드
//public class KMP{
//	public static int result, pi[];
//	public static String origin, pattern;
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		origin = br.readLine();
//		pattern = br.readLine();
//		
//		pi = new int[pattern.length()];
//		getPi();
//		KMP();
//	}
//	
//	private static void getPi() {
//		int j = 0;
//		for(int i=1; i<pattern.length(); i++) {
//			//맞는 위치가 나올때까지 j-1칸의 공통 부분 위치로 이동
//			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
//				j = pi[j-1]
//			}
//			//맞는 경우
//			if(pattern.charAt(i) == pattern.charAt(j)) {
//				//길이 문자열의 공통 길이는 j위 위치 +1
//				pi[i] = ++j;
//			}
//		}
//	}
//	
//	private static void KMP() {
//		int j = 0;
//		for(int i=0; i<origin.length(); i++) {
//			//맞는 위치가 나올떄까지 j-1칸의 공통 부분 위치로 이동
//			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
//				j = pi[j-1];
//			}
//			//맞는 경우
//			if(origin.charAt(i) == pattern.charAt(j)) {
//				if(j == pattern.length() -1) {
//					result = 1;
//					break;
//				}
//				//맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
//				else
//					++j;
//					
//			}
//		}
//		System.out.println(result);
//	}
//}

public class KMP알고리즘_부분문자열 {
	
	static int answer = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String origin = br.readLine();
		String pattern = br.readLine();
		//P가 S의 부분 문자열이면 return 1, or 0
		
		KMP(origin, pattern);
		System.out.println(answer);
	}
	
	public static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for(int i=1; i<pattern.length(); i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j))
				pi[i] = ++j;
		}
		return pi;
	}
	
	public static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		int j = 0;
		for(int i=0; i<origin.length(); i++) {
			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					answer = 1;
					break;
				}
				else
					j++;
			}
		}
	}

}