package 구현;
class Solution {
    //n진법, 숫자의 개수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    public String solution(int n, int t, int m, int p) {
       String s = "0";
		int count = 0;
		
		while(s.length() <= t*m +p) {
			String nthNum = "";
			int nth = count++;
				
			//10진수를 n진수로 바꾸는 과정
				while(nth != 0) {
					//10이상은 A B C D E F
					if(nth % n >= 10) {
						nthNum += String.valueOf((char)('A' + (nth % n) - 10));
					}else {
						nthNum += String.valueOf(nth%n);
					}
					nth /= n;
				}
				s += new StringBuffer(nthNum).reverse().toString();
		}
		
		String answer = "";
		for(int i=0; i<t; i++) {
			answer += String.valueOf(s.charAt(m*i +p -1));
		
		}
		return answer;

    }
}