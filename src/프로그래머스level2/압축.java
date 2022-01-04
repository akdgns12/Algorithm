package 프로그래머스level2;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * msg 대문자로만 이뤄진 문자열이 주어진다.
 */
/*
 * LZW 압축은 다음 과정을 거친다.

1.길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
2.사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
3.w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
4.입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
5.단계 2로 돌아간다.
 */
public class 압축 {
	public int[] solution(String msg) {
		//길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
		//출력할 색인 번호를 담은 ArrayList
		ArrayList<Integer> list = new ArrayList<>(); 
		//사전의 값을 담을 HashMap
		HashMap<String, Integer> dic = new HashMap<>();
		
		for(int i=1; i<27; i++) { // (A~Z) LZW 1번과정
			char alpha = (char)(64+i);
			dic.put(String.valueOf(alpha), i);
		}
		
		// 2,3,4 과정
		for(int i=0; i<msg.length(); i++) {//단어의 처음부터 끝까지 하나하나 확인한다
			String Key = msg.charAt(i) + ""; //i번째에 해당하는 단어 즉 현재 입력(w)
			int index = i + 1; //다음 글자(c)를 얻기 위한 index
			
			while(index<=msg.length()) { //단어의 마지막까지 확인하면서 사전에 있나없나 확인해야함
				if(index == msg.length()) {//단어의 마지막까지 온 경우
					list.add(dic.get(msg.substring(i))); //i부터 마지막 단어까지 글자에 대응되는 색인번호를 출력
					i = index; //i값을 index값으로 설정해 반복문이 끝나도록 한다.
					break;
				}
				
				String nextKey = msg.substring(i, index+1); //현재입력(w) + 다음글자(c)
				if(dic.containsKey(nextKey)) { // w+c가 있다면 다시 index를 하나 높여 다음글자가 사전에 있는지 확인
					index++;
				}else { //다음 글자가 사전에 없음
					//반복문을 돌며 다음 문자가 있을 때마다 key의 길이는 변하기 때문에 구해진 다음 index전까지로 key를 다시 설정한다.
					Key = msg.substring(i, index);
					list.add(dic.get(Key)); //그 때의 key값에 대응되는 색인번호 출력
					dic.put(nextKey, dic.size()+1); //w+c 사전에 추가
					i = index-1; //다음 글자의 index부터 다시 LZW
					break;
				}
			}
		}
		
		//list에서 answer로 데이터 빼오기
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
