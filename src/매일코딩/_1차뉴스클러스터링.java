package 매일코딩;

public class _1차뉴스클러스터링 {
	import java.util.*;
	class Solution {
	    public int solution(String str1, String str2) {
	        int answer = 0;
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
}
