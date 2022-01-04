package 문자열;

import java.util.ArrayList;
import java.util.Collections;

public class _1차뉴스클러스터링_level2 {
	public int solution(String str1, String str2) {
		int answer = 0;
		
		ArrayList<String> multiset1 = new ArrayList<String>();
		ArrayList<String> multiset2 = new ArrayList<String>();
		ArrayList<String> equalset = new ArrayList<String>();
		ArrayList<String> sumset = new ArrayList<String>();
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		for(int i=0; i<str1.length()-1; i++) {
			char first = str1.charAt(i);
			char second = str1.charAt(i+1);
			
			if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				multiset1.add(first + "" + second);
			}
		}
		for(int i=0; i<str2.length()-1; i++) {
			char first = str2.charAt(i);
			char second = str2.charAt(i+1);
			
			if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				multiset2.add(first + "" + second);
			}
		}
		
		Collections.sort(multiset1);
		Collections.sort(multiset2);
		
		for(String str : multiset1) {
			if(multiset2.contains(str)) {
				equalset.add(str);
				multiset2.remove(str);
			}
			sumset.add(str);
		}
		
		for(String str : multiset2) {
			sumset.add(str);
		}
		
		double j = 0;
		
		if(sumset.size() == 0	) {
			j = 1;
		}else {
			j = (double)equalset.size() / (double)sumset.size();
		}
		
		return (int)j*65536;
	}
}