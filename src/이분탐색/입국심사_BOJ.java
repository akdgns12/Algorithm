package �̺�Ž��;

import java.util.Arrays;

public class �Ա��ɻ�_BOJ {
	public long solution(int n, int[] times	) {
		//�̺�Ž�� �̿�
		/*
		 * int BinarySearch(int arr[], int target) {
		 * 
    		int start = 0;
		    int end = arr.length - 1;
		    int mid;
		
		    while(start <= end) {
		        mid = (start + end) / 2;
		
		        if (arr[mid] == target)
		            return mid;
		        else if (arr[mid] > target)
		            end = mid - 1;
		        else
		            start = mid + 1;
		    }
		    return -1;
		}
		 */
		
		
		/*
		 * 1. ����(start, mid, end)�� �̺� Ž���� ���̰� � ��(���� BinarySearch �ڵ��� target) ���Ͽ� ���� Ž�� ������ ������ ���� ã��
=> �̺� Ž���� ��: �ɻ縦 �޴µ� �ɸ��� �ð�(mid)
=> �񱳴��(target) : n(�Ա� �ɻ縦 ��ٸ��� ���)

2. �ɻ縦 �޴µ� �ּҷ� �ɸ��� �ð�(answer)�� ���ϹǷ� �ɻ縦 �޴µ� �ɸ��� �ð�(mid)�� �̺� Ž����

3. Input���� �� ������� n(�Ա� �ɻ縦 ��ٸ��� ���)���� �־����Ƿ� n���� target���� ���� ���� Ž�� ������ ����

4. n�� ���ϱ����� �־��� mid �ð����� �˻��� �� �ִ� ��� ��(sum)�� ���ϴ� �˰����� ���ԵǾ����

5. answer�� ���ϱ� ���� �ּ� �ð��� ã�Ƴ�����

�̺� Ž�� �˰��� �ڵ�� �ذ� ����� �����Ͽ� �����ϸ� �Ʒ��� ���� �ڵ尡 �� �� ����
		 */
		//��� ����� �ɻ縦 �޴µ� �ɸ��� �ð��� �ּڰ�
		long answer = Long.MAX_VALUE;
		
		Arrays.sort(times);
		
		long start, mid, end;
		start = 0;
		end = Long.MAX_VALUE;
		long sum;
		//��� ����� �ɻ� �޴µ� �ɸ��� �ð� �̺� Ž��
		//mid : �ɻ縦 �޴µ� �־��� �ð�
		//sum : �־��� �ð�(mid)���� �ɻ縦 ���� �� �ִ� ��� ��
		while(start <= end) {
			mid = (start+ end)/2;
			
			sum = 0;
			//�־��� �ð����� ��� �˻� �� �� �ִ��� ������
			for(int i=0; i<times.length; i++) {
				sum += mid/times[i];
				
				if(sum >= n)
					break;
			}
			
			//�� ���(��� ��)
			//�˻� �� ���� ��(�ð�����)
			if(n > sum) {
				start = mid +1;
			}
			//�˻� �� ���� ��(�ð��� ����)
			//�ּ� �ð� ã�ƾ���
			else {
				end = mid -1;
				answer = Math.min(answer, mid);
			}
		}
		
		return answer;
	}
}
