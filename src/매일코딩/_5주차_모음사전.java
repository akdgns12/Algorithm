package �����ڵ�;

public class _5����_�������� {
	// ���α׷��ӽ� lv2 / ��Ŭ�� 5���� / ��������
	class Solution {
	    public int solution(String word) {
	        int answer = 0;
	        char[] ch = {'A', 'E', 'I', 'O', 'U'};
	        int sum = 781;
	        for(int i=0; i<word.length(); i++){
	            for(int j=0; j<5; j++){
	                if(ch[j] == word.charAt(i)){
	                    answer += 1 + j * sum;
	                }
	            }
	            sum = (sum - 1) / 5;
	        }
	        return answer;
	    }
	}
}
