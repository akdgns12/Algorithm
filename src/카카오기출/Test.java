package 카카오기출;

public class Test {
	public int solution(String s) {
		int answer;
		
		String[] sen = {"zero", "one", "two", "three",
				"four", "five", "six","seven", "eight","nine"};
		
		char[] ch = s.toCharArray();
		String temp = "";
		String conanswer = "";
		//문자열 s를 돌면서
		for(int i=0; i<ch.length; i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				temp += Character.toString(ch[i]);
				for(int j=0; j<sen.length; j++) {
					if(temp == sen[j]) {
						conanswer += String.valueOf(j);
						temp = "";
					}
				}
			}else if(ch[i] >= '0' && ch[i] <= '9') {
				conanswer += ch[i];
			}
		}
		
		answer = Integer.parseInt(conanswer);
		
		return answer;
	}
}
