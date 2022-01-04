package 카카오기출;

import java.util.*;
import java.util.Collections;
//이분탐색
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *  1. 점수를 제외한 info로 가능한 모든 조합을 구해 key를 만든다
	2. 구한 key 마다 List를 생성해 점수를 add
	3. 점수 List를 오름차순 정렬
	4. query에서 '-'를 제외한 조건으로 key를 만들고 점수 List를 가져온다
	5. 이분탐색을 통해 주어진 점수 이상인 사람들의 수를 센다
 */
public class _2021순위검색 {
	Map<String, Integer> Wordmap = new HashMap<>();
	List<List<Integer>> ScoreList = new ArrayList<>();
	
	public int[] solution(String[] info, String[] query) {
		Wordmap.put("-", 0);
		Wordmap.put("cpp", 1);
		Wordmap.put("java", 2);
		Wordmap.put("python", 3);
		Wordmap.put("backend", 1);
		Wordmap.put("frontend", 2);
		Wordmap.put("junior", 1);
		Wordmap.put("senior", 2);
		Wordmap.put("chicken", 1);
		Wordmap.put("pizza", 2);
		for(int i=0; i<4*3*3*3; i++) {
			ScoreList.add(new ArrayList<>());
		}
		
		for(String str : info) {
			String[] word = str.split(" ");
			int[] arr = {Wordmap.get(word[0]) *3*3*3,
					Wordmap.get(word[1]) *3*3,
					Wordmap.get(word[2]) *3,
					Wordmap.get(word[3])};
			int score =Integer.parseInt(word[4]);
			
			for(int i=0; i<(1<<4); i++) {
				int idx = 0;
				for(int j=0; j<4; j++) {
					if((i & (1<<j)) !=0) {
						idx += arr[j];
					}
				}
				ScoreList.get(idx).add(score);
			}
		}
		for(int i=0; i<4*3*3*3; i++) {
			Collections.sort(ScoreList.get(i));
		}
		
		int[] answer = new int[query.length];
		for(int i=0; i<query.length; i++) {
			String[] word = query[i].split(" ");
			int idx = Wordmap.get(word[0]) *3*3*3 +
					Wordmap.get(word[2]) *3*3 +
					Wordmap.get(word[4]) *3 +
					Wordmap.get(word[6]);
			int score =  Integer.parseInt(word[7]);
			int ret = Collections.binarySearch(ScoreList.get(idx), score);
			// binarysearch만으로는 가장작은 idx를 알 수 없다.(점수 중복될 수 있는 문제)
			 if(ret <0) {
				 ret = -(ret + 1);
			 }else {
				 for(int j=ret - 1; j >= 0; j--) {
					 if(ScoreList.get(idx).get(j) == score) {
						 ret = j;
					 }else {
						 break;
					 }
				 }
			 }
			 answer[i] = ScoreList.get(idx).size() - ret;
		}
		
		return answer;
	}
}
