package �����ڵ�;

public class ����Ʈ {
	import java.util.Arrays;
	class Solution {
	    public int solution(int[] people, int limit) {
	        int answer = 0;
	        Arrays.sort(people);
			
			//�����԰� ���� ������ ��� index
			int index = 0;
			for(int i=people.length-1; i>=index; i--) {
				
				//�ִ� �ּ� ���� limit���� ũ�� ���� ���ſ� ��� ���� ����
				if(people[i] + people[index] > limit) {
					answer++;
				}
				
				// �ִ� �ּ� ���� limit���� �۰ų� ������ �Ѵ� ����
				else {
					index++;
					answer++;
				}
			}
	        return answer;
	    }
	}
}
