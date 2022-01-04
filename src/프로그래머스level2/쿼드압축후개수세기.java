package ���α׷��ӽ�level2;

/*
 * ��͹���.
 * �ش� �迭�� ���Ե� ���ڰ� ��� �������� üũ.
 * ���� �ƴ϶��, �� �κ����� �����ش�. �´ٸ� �� �κ��� �� �̻� Ž������ �ʴ´�.
 * 1.arr�� ũ�Ⱑ 1�̶�� �ش� arr�� ��Ұ� 0����, 1���� �����ش�
 * 2. arr�� ũ�Ⱑ 1�� �ƴ϶��, �ش� arr�� ��Ұ� ���� ������� �����ش�.
 * 2-1 ���� ���, �ش� �κп� �ش��ϴ� ���(0 or 1)�� ī��Ʈ�� ���������ش�.
 * 2-2 ���� ���� ���, �� �κ����� ������ ����Լ��� �����ش�.
 */
public class ��������İ������� {
	static int[][] map;// arr��������
	static int zero, one;  // �� ���� ī��Ʈ
	public int[] solution(int[][] arr) {
		int[] answer = {};
		int n = arr.length;
		map = arr;
		zero = 0;
		one = 0;
		check(0,0,n);
		
		answer = new int[2];
		answer[0] = zero;
		answer[1] = one;
		return answer;
	}
	//������ (x,y)���� k��ŭ üũ�Ѵٴ� ��
	public void check(int x, int y, int k) {
		if(isPossible(x, y, k)) {// (x,y)���� k���������� ���������� �̷���� ������
			int val =map[x][y]; //�� �� ��������
			if(val == 1) one++; //�´� ����++
			else zero++;
			return;
		}
		
		//���� ������ �̷���� �ִٸ�
		int half = k/2; //���� ���̱�
		//�� ������ �ٽ� ���ȣ��
		check(x, y, half);
		check(x, y+half, half);
		check(x+half, y, half);
		check(x+half, y+half, half);
	}
	
	//�Ķ���ͷ� ���� ������ ���� ������ �̷���� �ִ��� Ȯ���ϴ� �޼ҵ�
	public boolean isPossible(int x, int y, int k) {
		int val = map[x][y]; //�迭�� üũ�� ���� ��
		for(int i=x; i<x+k; i++) {
			for(int j=y; j<y+k; j++) {
				if(map[i][j] !=val)return false; //�ٸ��� �ϳ��� ������ F
			}
		}
		return true; //��� �� ���� ��
	}
}


