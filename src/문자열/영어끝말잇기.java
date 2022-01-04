package 문자열;

import java.util.ArrayList;

public class 영어끝말잇기 {
	public int[] solution(int n, String[] words) {
	int[] answer = new int[2];
	ArrayList<String> list = new ArrayList<String>();
	// 체크해야하는 것 2가지
	//1. 새로말하는 단어의 첫글자가 이전 단어의 마지막글자와 다르거나
	//2. 이미 말한 단어를 또 말하는 경우
	// list에 단어 넣어가면서 비교해서 나온단어일 경우 break;
	
	int i; //총 게임 진행 횟수
	list.add(words[0]);
	for(i=1; i<words.length; i++) {
		char prev = words[i-1].charAt(words[i-1].length()-1); // 끝문자
		
		char curr = words[i].charAt(0); // 첫문자
		
		if(list.contains(words[i])) break;
		
		if(prev != curr) break; // 끝문자가 이전 단어의 마지막 문자와 다르다면 종료
		
		list.add(words[i]);
	}
	
	if(i == words.length) {
		answer[0] = 0;
		answer[1] = 0;
	}else {
		answer[0] = i%n +1;
		answer[1] = i/n +1;
	}
	
	
	
	return answer;
}
}
