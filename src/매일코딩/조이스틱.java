package �����ڵ�;

public class ���̽�ƽ {
	// �����̵�, �¿��̵�
	// �¿��̵��� ���
	// ���������θ� ������� �̵��ϴ� ��� -> len - 1�� �̵�
	// (���������� ���ٰ�)���ӵ� A�� ���� �ٽ� �������� ���ư� �̵��ϴ� ���
	class Solution {
	    public int solution(String name) {
	        int answer = 0;
	        int len = name.length(); 
	        int move = len - 1; // ���������θ� ������� �̵��ϴ� ��� len-1�� �̵�
	        
	        
	        for(int i=0; i<name.length(); i++){
	            char c = name.charAt(i);
	            // �����̵�
	            if('M' - c >= 0){ // A���� M����
	                answer += c - 'A';
	            }else{ // M���� Z����
	                answer += 'Z' - c + 1;
	            }
	            
	            int nextIdx = i + 1;
	            // ���� ���ں��� ���ӵ� A�� �ִ� ��� �ǵ��ư��°� ������ Ȯ��
	            while(nextIdx < len && name.charAt(nextIdx) == 'A'){
	                nextIdx++;
	            }
	            
	            move = Math.min(move, i+i+len-nextIdx);
	        }
	        
	        answer+=move;
	        return answer;
	    }
	}
}
