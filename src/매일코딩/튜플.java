package �����ڵ�;

public class Ʃ�� {
	import java.util.*;

	class Solution {
	    public int[] solution(String s) {
	    	//1. Ʃ���� ���� ArrayList ��ü
	        ArrayList<Integer> result = new ArrayList<>();
	        // 2. ���� ���� {{�� �����Ѵ�
	        s = s.substring(2, s.length());
	        // 3. ���� ���� }}�� ������ ��, },{ ������ ���ڿ��� -�� �ٲ۴�
	        s = s.substring(0, s.length()-2).replace("},{", "-");
	        // 4. ������ �ٲ� ���ڿ��� �������� split ���ش�.
	        String[] arr = s.split("-");
	        
	        // 5. ������ ���ڿ� �迭�� ���̿� ���� �ٽ� �����Ѵ�.
	        Arrays.sort(arr, new Comparator<String>(){
	            @Override
	            public int compare(String o1, String o2){
	                return Integer.compare(o1.length(),o2.length());
	            }
	        });
	        
	        
	        // 6. �� ���ڿ��� Ž��
	        for(String x : arr){
	        	// 7. �� ���ڿ����� ,�� �������� split�Ͽ� ���ο� ���ڿ� �迭�� �����
	            String[] temp = x.split(",");
	            // 8. ���� ���� ���ڿ� �迭���� �������� �����ϸ� �̸� Ž���Ѵ�
	            for(int i=0; i<temp.length; i++){
	            	// 9. �� ���ڿ� ���� ������ �ٲ۴�
	                int n = Integer.parseInt(temp[i]);
	                // 10. Ʃ�ÿ� ����ִ� ���̸� skip, �ȵ���ִٸ� �߰�
	                
	                if(result.contains(n))
	                    continue;
	                result.add(n);
	            }
	        }
	        
	        // Ʃ�ÿ� �ִ� ���� answer�迭�� ����
	        int[] answer = new int[result.size()];
	        for(int i=0; i<result.size(); i++){
	            answer[i] = result.get(i);
	        }
	        
	        
	        return answer;
	    }
	}
}
