package ����;
class Solution {
    //n����, ������ ���� t, ���ӿ� �����ϴ� �ο� m, Ʃ���� ���� p
    public String solution(int n, int t, int m, int p) {
       String s = "0";
		int count = 0;
		
		while(s.length() <= t*m +p) {
			String nthNum = "";
			int nth = count++;
				
			//10������ n������ �ٲٴ� ����
				while(nth != 0) {
					//10�̻��� A B C D E F
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