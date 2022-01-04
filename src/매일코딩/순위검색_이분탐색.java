package 매일코딩;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색_이분탐색 {
	import java.util.*;
	// 조건을 만족하는 사람 중 코테 점수 X점 이상 받은 사람은 몇명인가?
	// 개발팀의 문의조건에 맞는 사람들의 숫자를 순서대로 배열에 담아 return

	/*
	풀이 
	이분탐색
	입력받은 지원자의 정보들로 만들어 질 수 있는 모든 경우의 수를 조합 알고리즘을 사용하여 map에 담아준다.
	각 경우의 수로 조합된 문자열이 key값, 점수가 value가 된다
	조합이 완료되면 이분탐색을 위해 점수를 기준으로 데이터를 정렬하고,
	이분탐색을 통해 갯수를 answer배열에 리턴
	*/
	class Solution {
	    static HashMap<String, ArrayList<Integer>> map;
	    
	    public int[] solution(String[] info, String[] query) {
	        int[] answer = new int[query.length];
	        map = new HashMap<>();
	        
	        for(String str : info){
	            String[] infoArr = str.split(" ");
	            combi("", 0, infoArr);
	        }
	        
	        int queryIdx = 0; 
	        for(String q : query){
	            String str = q.replace(" and ", "");
	            String[] tmp = str.split(" "); // key, value : 문자열, 점수 나눠주기 위해 공백 기준 split 
	            // tmp[0] = 문자열, tmp[1] = 점수
	            Collections.sort(map.get(tmp[0])); // 해당 문자열에 맞는 key값 가진 점수 리스트 오름차순 정렬 
	            answer[queryIdx++] = binarySearch(tmp[0], Integer.parseInt(tmp[1]));
	        }
	        
	        return answer;
	    }
	    
	    public static void combi(String str, int depth, String[] arr){
	        if(depth == 4){
	            int score = Integer.parseInt(arr[4]);
	            if(map.containsKey(str)) { // 이 부분 이해가 감
	                // map이 str가지고 있으면
	                // 리스트 형태의 점수 리스트에 점수 추가해줌 
	                map.get(str).add(score);
	            }else{
	                ArrayList<Integer> temp = new ArrayList<>();
	                temp.add(score);
	                map.put(str, temp);
	            }
	            return;
	        }
	        
	        combi(str + "-", depth + 1, arr);
	        combi(str + arr[depth], depth + 1, arr);
	    }
	    
	    public static int binarySearch(String query, int score){
	        if(!map.containsKey(query))
	            return 0;
	        ArrayList<Integer> tmpList = map.get(query);
	        int start = 0, end = tmpList.size()-1;
	        
	        while(start <= end){
	            int mid = (start + end) / 2;
	            
	            if(score > tmpList.get(mid))
	                start = mid + 1;
	            else end = mid -1;
	        }
	        return tmpList.size() - start;
	    }
	}
}
