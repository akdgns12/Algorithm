package Greedy;

import java.util.Arrays;
import java.util.Comparator;
/*
 * 1. Union-Find(������ ã��)
 * �� ���� ������ ���� �θ�� ����Ǿ��ִ��� Ȯ���� �� �ִ� �˰���.
 * �� ��������, ������ �ִ� �ֻ��� �θ� ��带 ����Ѵ�
 * �θ��� ������ �� ���� ���� �ȴ�.
 * ���� 2�� 1�� �θ� ������ �ִٸ� arr[2] = 1; ������ ǥ��.
 * 
 * 2.ũ�罺Į �˰���
 * ���� ���� ������� ��� ��带 �����ϱ� ���� ����ϴ� �˰���.
 * ���� �־��� ����ġ�� ������������ �����Ѵ�.
 * �׸��� ���� ���ߺ��� ������ �����ϸ鼭 �׷����� ������.
 * �׷����� ����鼭 �����ؾ� �� ����, �����Ϸ��� �� ������ �̹� ����Ǿ��ִٸ�
 * ���ܽ����־�� �Ѵٴ� ��.
 * �׷��� ������, ���� �� �� ���� ���� Skip, ���� �� �� �ִ� ��쿡�� �ֻ���
 * �θ� ��带 update�������ش�.
 * �̷��� �־��� �׷����� ��� ������ ���� ����ġ�� �������� �ٿ� ������ ����, 
 * �ּҺ���� ����ϴ� ������ ���� �����ϰ� ���Ŀ� ���� ����� ū ���� 
 * skipó���� �Ǿ� ��� ������ �ּҺ������ ������ �� �ְ� �ȴ�.
 * 
 */
public class �������ϱ�_lv3 {
	static int[] findParent;  //�θ�� �ڽ��� ������ ��� �迭
	
	public int find(int child) {
		if(findParent[child] == child) { //�θ� ã��
			return child;
		}else {
			return findParent[child] = find(findParent[child]);
		}
		
	}
	
	public int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() { //����ġ �������� ��������
			@Override
			public int compare(int[] o1, int[] o2) {
				Integer a = o1[2];
				Integer b = o2[2];
				return a.compareTo(b);
			}
		});
		
		findParent = new int[n]; // �ʱ�迭���� �θ�� �ڱ��ڽ�.
		for(int i=0; i<n; i++) {
			findParent[i] = i;
		}
		
		int answer = 0;
		for(int i=0; i<costs.length; i++) {
			int firstIsland = find(costs[i][0]);
			int secondIsland = find(costs[i][1]);
			if(firstIsland != secondIsland) { //�θ� ���� �ʴٸ� ������ �ȵ� �ּڰ��̹Ƿ�
				findParent[secondIsland] = firstIsland; //����
				answer += costs[i][2];
			}
		}
		
		return answer;
	}
}
