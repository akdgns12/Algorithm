package ���α׷��ӽ�_Level_1;
/*
 * ������ ������ �迭, arr���� ���� ���� ���� ������ �迭�� return�ϴ� �Լ�
 * solution�� �ϼ��϶�
 * ��, return�Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� return
 * ������� arr�� [4,3,2,1]�� ���� [4,3,2]�� return�ϰ�,
 * [10]�̸� [-1]�� return
 */
/*
 * -�迭�� �� ���� length�� 1�� �迭 -> �׳� -1 ��Ƽ� return
 * -arr�� answer�� ���̰� 1����
 * -���� �� �� �ٸ� ���������� �̿��ؾ���.
 * -arr[j]�� �ּڰ��� ���� ���� answer�� �־����� ���ƾ���.
 */
public class ���������������ϱ� {
	public int[] solution(int[] arr) {
		int[] answer = {};
		int min = arr[0];
		if(arr.length == 1) {
			return new int[] {-1};
		}
		// �ּڰ� ���ϱ�
		for(int i=0; i<arr.length; i++) {
			min = Math.min(arr[i], min);
		}
		// answer�� arr���� 1����
		answer = new int[arr.length-1];
		
		int j = 0;
		for(int i=0; i<answer.length; i++) {
			if(arr[j] == min) { //arr[j]�� �ּڰ��� �������� answer�� �־����� ���ƾ���.
				j++;
				i--;
				continue;
			}
			answer[i] = arr[j];
			j++;
		}
		return answer;
	}
}
/*
 * ArrayList �̿��� list���� remove�Լ��� ������ Ǯ��
 int [] answer = {-1};
 ArrayList<Integer> list = new ArrayList<>();
 
 for(int a : arr)
	 list.add(a);
 
 int temp = arr[0];
 for(int a : list) { //�ּҰ� ���ϱ�
	 if(a<temp) {
		 temp = a;
	 }
 }
 lsit.remove(list.indexOf(temp)); //�ּҰ� ����
 
 if(list.size() > 1) {
	 asnwer = new int[list.size()];
	 
	 for(int i=0; i<list.size(); i++) {
		 answer[i] = list.get(i);
	 }
 }
return answer;
*/