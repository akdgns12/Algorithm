package �����ڵ�;
/*
 * �������
 * 1. Outter For������ index 0 - i������ substring ����
 * 2. Inner For������ i���̸�ŭ�� �ؽ�Ʈ�� �߶󰡸� output �ϼ�
 * 3. output�� ���̿� answer ���� �� ���� ������ answer ����
 * 4. answer ��ȯ
 */
class ����_���ڿ����� {
    public int solution(String s) {
    	int answer = 1000;
    	
    	for(int i=1; i<s.length()/2+2; i++) {
    		String subStr = s.substring(0, i);
    		String output = "";
    		int count = 1;
    		int lastIndex = 0;
    		
    		for(int j=i; j+i<=s.length(); j+= i) {
    			String strToCompare = s.substring(j, j+i);
    			
    			// ���ӵǴ� ���
    			if(subStr.equals(strToCompare)) {
    				count++;
    				// ���ӵ��� ���� ���
    			}else {
    				if(count > 1) {
    					output += count;
    					count = 1;
    				}
    				output += subStr;
    				subStr = strToCompare;
    			}
    			lastIndex = j+i;
    			
    			if(count > 1) {
        			output += count;
        			output += subStr;
        		}
    			
    			if(lastIndex < s.length()) {
    				output += s.substring(lastIndex);
    			}
    			
    			answer = Math.min(answer, output.length());
    		}
    		
    		
    	}
    	
    	return answer;
    }
}
