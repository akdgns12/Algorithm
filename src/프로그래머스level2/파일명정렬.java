package 프로그래머스level2;
/*
 * 파일명은 세부분으로 구성됨
 * HEAH, NUMBER, TAIL
 * 헤드는 문자로 이루어짐
 * 넘버는 한글자에서 최대 다섯글자 사이의 연속된 숫자 앞에 0이 올 수도 있다
 */
/*
 * 조건
 * 1.파일명은 우선 HEAD 부분을 기준으로 사전순으로 정렬. 대소문자 구분 x
 * 2.HEAD가 대소문자 차이 외에 같을 경우, NUMBER의 숫자순으로 정렬한다 
 *  - 앞에 0은 무시
 *  3.두 파일의 HEAD부분과, NUMBER의 숫자도 같을 경우, 
 *  	- 원래 입력에 주어진 순서를 유지한다.
 */
// Comparable은 기본적인 정렬위주일 떄 - 기준을 설정하고 정렬. 
// 특정한 기준 1가지를 가지고 정렬 ex)학점을 기준으로 오름차순 or 내림차순
// 특정한 규칙을 사용해 정렬할 때는 Comparator - 요구사항에서 주어진 특정 기준을
// 가지고 정렬 ex)학점이 같다면 이름순으로 정렬
public class 파일명정렬 {
	public String[] solution(String[] files) {
		String[] answer =  new String[files.length];
		
		
		for(int i=0; i<files.length; i++) {
			  String[] str = files[i].toLowerCase();
			  
		}
		
		
		
		
		
		
		
		return answer;
	}
}
