package �����ڵ�;

public class ������ȯ_���� {
	class Solution {
	    //s�� 1�� �ɶ����� ����ؼ� ������ȯ���� ��
	    // ������ȯ�� Ƚ���� ��ȯ �������� ���ŵ� ��� 0�� ����
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        
	        int count = 0;
	        int count_zero = 0;
	        
	        while(!s.equals("1")){
	            int count_one = 0;
	        for(int i=0; i<s.length(); i++){
	            if(s.charAt(i) == '1'){
	                count_one++;
	            }else{
	                count_zero++;
	            }
	        }
	             s = Integer.toBinaryString(count_one);
	            count++;
	        }
	       
	        answer[0] = count;
	        answer[1] = count_zero;
	        
	        return answer;
	    }
	}
}
