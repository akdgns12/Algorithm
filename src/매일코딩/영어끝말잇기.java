package 매일코딩;

public class 영어끝말잇기 {
	import java.util.*;
	class Solution {
	    public int[] solution(int n, String[] words) {
	        int[] answer = new int[2];//결과 배열 셋팅
	        //중복단어 체크하기 위해 ArrayList에 담는다
	     ArrayList<String> list = new ArrayList<>();
			// 체크해야할 조건 2가지
			//1. 새로말하는 단어의 첫 글자가 이전 단어의 마지막글자와 다르거나
			//2. 이미 말한 단어를 또 말하는 경우
		
			int i; //총 게임이 진행되는 횟수
			list.add(words[0]); // 첫 단어만 일단 넣어놓고 확인
			for( i=1; i<words.length; i++) {
				char prev = words[i-1].charAt(words[i-1].length() -1); // 끝단어
				char curr = words[i].charAt(0); //현재 처음단어
				
				if(list.contains(words[i])) break; //포함되어 있다면 종료
				
				if(prev != curr) break; //현재 첫 단어와 이전 마지막 단어가 다르면 종료
				
				list.add(words[i]); //현재 단어를 중복 리스트에 담는다.
			}
			
			if(i == words.length) { //탈락자가 생기지 않을 때,
				answer[0] = 0;
				answer[1] = 0;
			}else { // 탈락자가 나왔을 때,
				answer[0] = i%n +1; //총 횟수를 n명으로 나눈 나머지 +1이 현재 탈락자의 번호
				answer[1] = i/n +1; // 몫 +1은 몇 차례인지를 알려줌
			}

	        return answer;
	    }
	}
}
