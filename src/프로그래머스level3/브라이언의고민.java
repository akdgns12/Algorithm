package 프로그래머스level3;

public class 브라이언의고민 {
	public String solution(String sentence) {
		String answer = "";
		int[] alp = new int[26];
		//문장 앞뒤 공백 없어야하고 단어사이의 공백은 한글자이여야함.
		//규칙에 맞게 변환할 수 없으면 invalid 리턴
		//
		
		for(int i=0; i<sentence.length(); i++) {
			char c = sentence.charAt(i);
			if(c <= 'z' && c >= 'a') {
				alp[c - 'a']++;
			}else if(c == ' ') {
				return answer = "invalid";
			}
		}
		
		//규칙 1
		for(int i=0; i<alp.length; i++) {
			char ch = (char)('a' + i);
			if(alp[i] > 0) {
				int s = answer.indexOf(ch);
				int e = answer.lastIndexOf(ch);
				
				if(alp[i] == 1) {
			}
		}
		
		return answer;
	}
}
