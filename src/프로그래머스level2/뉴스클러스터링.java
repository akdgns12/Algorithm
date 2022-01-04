package 프로그래머스level2;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 2018카카오 공채
 * 
 * 예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 
 * 교집합 A ∩ B = {2, 3}, 합집합 A ∪ B = {1, 2, 3, 4}이 되므로,
 *  집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다. 
 *  집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 
 *  J(A, B) = 1로 정의한다.
 */
public class 뉴스클러스터링 {
	public int solution(String str1, String str2) {
		int answer = 0;
		/*
		 * 1.입력으로 들어온 두 문자열을 두 글자씩 끊어서 다중집합의 원소로 만들기
		 *	조건 1-1 영문자로 된 글자쌍만 유효 나머지는 버린다.
		 *	   1-2 대문자와 소문자의 차이는 무시.
		 */
		// str1의 두글자씩 끊은 list
		ArrayList<String> multiSet1 = new ArrayList<>();
		// str2의 두글자씩 끊은 list
		ArrayList<String> multiSet2 = new ArrayList<>();
		// 교집합
		ArrayList<String> equalSet  = new ArrayList<>();
		// 합집합
		ArrayList<String> sumSet = new ArrayList<>();
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		for(int i=0; i<str1.length() -1; i++) {
			char first = str1.charAt(i);
			char second = str1.charAt(i+1);
			
			if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'	) {
				multiSet1.add(first + "" + second);
			}
		}
		
		for(int i=0; i<str2.length() -1; i++) {
			char first = str2.charAt(i);
			char second = str2.charAt(i+1);
			
			if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'	) {
				multiSet2.add(first + "" + second);
			}
		}
		/*두 집합의 교집합과 합집합을 구한다
		중복원소의 처리를 위해 먼저 두 집함을 정렬
		집합1의 원소를 하나씩 꺼내어 집합2에 포함되는지 확인
			집합2에 포함된다면 교집합에 넣고 집합2에서 삭제
			집합2에 포함됨과 상관없이 합집합에 넣는다
		집합2에 남아있는 원소를 합집합에 모두 넣는다
		 */
		Collections.sort(multiSet1);
		Collections.sort(multiSet2);
	
		for(String s : multiSet1) {
			if(multiSet2.contains(s)) {
				equalSet.add(s);  //교집합
				multiSet2.remove(s);
			}
			sumSet.add(s); //합집합
		}
		
		for(String s : multiSet2) {
			sumSet.add(s);
		}
		
		double jakard = 0;
		
		if(sumSet.size() == 0) {
			jakard = 1;
		}else {
			jakard = (double)equalSet.size() / (double)sumSet.size();
		}
		
		
		
		return (int)(jakard * 65536);
	}
}
