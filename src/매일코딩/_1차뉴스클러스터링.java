package �����ڵ�;

public class _1������Ŭ�����͸� {
	import java.util.*;
	class Solution {
	    public int solution(String str1, String str2) {
	        int answer = 0;
	        ArrayList<String> multiSet1 = new ArrayList<>();
			// str2�� �α��ھ� ���� list
			ArrayList<String> multiSet2 = new ArrayList<>();
			// ������
			ArrayList<String> equalSet  = new ArrayList<>();
			// ������
			ArrayList<String> sumSet = new ArrayList<>();
			
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();
			
			for(int i=0; i<str1.length() -1; i++) {
				char first = str1.charAt(i);
				char second = str1.charAt(i+1);
				
				if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'	) {
					multiSet1.add(first + "" + second);
				}
			}
			
			for(int i=0; i<str2.length() -1; i++) {
				char first = str2.charAt(i);
				char second = str2.charAt(i+1);
				
				if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z'	) {
					multiSet2.add(first + "" + second);
				}
			}
			/*�� ������ �����հ� �������� ���Ѵ�
			�ߺ������� ó���� ���� ���� �� ������ ����
			����1�� ���Ҹ� �ϳ��� ������ ����2�� ���ԵǴ��� Ȯ��
				����2�� ���Եȴٸ� �����տ� �ְ� ����2���� ����
				����2�� ���Եʰ� ������� �����տ� �ִ´�
			����2�� �����ִ� ���Ҹ� �����տ� ��� �ִ´�
			 */
			Collections.sort(multiSet1);
			Collections.sort(multiSet2);
		
			for(String s : multiSet1) {
				if(multiSet2.contains(s)) {
					
					equalSet.add(s);  //������
	                multiSet2.remove(s);
				}
				sumSet.add(s); //������
			}
			
			for(String s : multiSet2) {
				sumSet.add(s);
			}
			
			double jakard = 0;
			
			if(sumSet.size() == 0) {
				jakard = 1;
			}else {
				jakard = (double)equalSet.size() / (double)sumSet.size();
			}
			
			
			
			return (int)(jakard * 65536);
	    }
	}
}
