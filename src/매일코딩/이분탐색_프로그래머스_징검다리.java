package �����ڵ�;

import java.util.Arrays;
/*
 �̺�Ž���� �ϱ� ���� �迭�� �����ϰ�
 ���� ������ �ּҰŸ��� mid�� �����س���, �̺��� ������ �ּ� �Ÿ��� ������ mid�� �ݷ��̹Ƿ� �����Ѵ�.
 ������ ������ ��� ���� �������� ���� ���� ������ ���� �˰� �־�� �ϹǷ� lastRock�� �ξ� ��������
 �ʾ��� ��� ������� �߿��� �������� �������� �����Ѵ�.
 ������ ������ ������������ �Ÿ��� mid�� ���ؾ� �ϹǷ� for�� ������ if���� �߰��Ѵ�.
 ������ ���� ���� remove�� n���� ũ�ٸ� mid�� ũ�ٴ� ���̹Ƿ� ���̰�, �ݴ��� �ø���.
 answer���� remove<=n�϶� �ִ��� �����Ѵ�.
 */
public class �̺�Ž��_���α׷��ӽ�_¡�˴ٸ� {
	  public int solution(int distance, int[] rocks, int n) {
	        int answer = 0;
	        Arrays.sort(rocks);
	        
	        int start = 1;
	        int end = distance;
	        int mid; // ���� ������ �ּҰŸ�
	        int remove = 0; //������ ���� ����
	        int lastRock = 0; // ������ ����
	        while(start <= end) {
	        	mid = (start + end) / 2;
	        	for(int i=0; i<rocks.length; i++) {
	        	if(rocks[i] - lastRock < mid) remove++;
	        	else
	        		lastRock = rocks[i];
	        }
	        	
	        	if(distance - lastRock < mid) remove++; // ������ ������ ���������� �Ÿ� üũ
	        	
	        	if(remove > n) end = mid - 1;
	        	else {
	        		answer = Math.max(answer, mid); 
	        		start = mid + 1;
	        	}
	        	remove = 0;
	        	lastRock = 0;
	        return answer;
	    }
}
