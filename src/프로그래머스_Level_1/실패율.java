package ���α׷��ӽ�_Level_1;

import java.util.HashMap;

/* 
 * ������ = ���������� ���������� ���� Ŭ�������� ���� �÷��̾��� �� 
 * / ���������� ������ �÷��̾� ��
 * ��ü ���������� ���� N
 * ������ �̿��ϴ� ����ڰ� ���� �����ִ� ���������� ��ȣ�� ��� �迭 stages
 * �������� ���� ������������ ������������ ���������� ��ȣ�� ����ִ� �迭��
 * return �ϵ��� �ϴ� solution �ϼ��϶�.
 */
/*<�˰���>
 * ���� Ŭ�������� ���� �÷��̾��� ��  = ���� ���������� ������ �÷��̾��� ��
 * ���������� ������ �÷��̾� �� = ���� ���������� ������ �÷��̾���� ���� ������������
 * ���ܰ� ���������� ������ �÷��̾��� ���� ��
 * 
 * ���� �� ���������� �������� �����ų �迭�� �ʿ��ϴ�. �̸� answer�̶�� �ϰ�
 * ���̴� N���� ������. ������, stages�迭�� Ž���� ����. stages�� Ž���ϸ鼭
 * �� stage�� ����� �÷��̾ �ִ��� Ȯ���� �ϸ�ȴ�. �� ��, ���� �ݺ�����
 * Ȱ���ؼ� stage1�� ���Ե� �÷��̾� ���� ã��, stage2�� �÷��̾� ���� ã�� �������
 * Ž���� �����ϸ� �ȴ�.
 * �������� ���ǿ� ����, �������� ���� �� �̸� map �ڷᱸ���� ��������.
 * key���� stage�� �ϰ� value�� �� stage�� ������.
 * ���������� map�� Ž���ϸ鼭 ū ���� ã�Ƴ��� �̸� answer�迭�� �߰��ϴ� ���
 * ���� ��üŽ���� �����ϸ� �������� ���� ������� ���ĵ� �� stage�� answer�迭��
 * ���� �� �ִ�.
 * 
 */
public class ������ {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		HashMap<Integer, Double> failmap = new HashMap<Integer,Double>();
		
		for(int i=1; i<=N; i++) {
			int stage = i;
			int incompletePlayers = 0; //���� Ŭ�������� ���� �÷��̾��� ��
			int curretStageTotalPlayers = 0; // ���������� ������ �÷��̾��� ��
			
			for(int j=0; j<stages.length; j++) {
				int player =stages[j];
				
				if(stage == player) {
					incompletePlayers++;
				}
				if(player >= stage) {
					curretStageTotalPlayers++;
				}
			}
			
			double failureRate = 0;
			
			if(incompletePlayers != 0 && curretStageTotalPlayers !=0) {
				failureRate = (incompletePlayers / (double)curretStageTotalPlayers);
			}
			failmap.put(stage, failureRate);
		}
		
		for(int i=0; i<N; i++) {
			double max = -1;
			int maxkey = 0;
			for( Integer key : failmap.keySet()) {// hashmap��ü�� Ž���ϸ鼭 ���� ū �������� ����  �װ� arr[i]��°�� �����ѵ� ���� 
				if(max < failmap.get(key)) {
					max = failmap.get(key);
					maxkey = key;
				}
			}
			
			answer [i] = maxkey;
			failmap.remove(maxkey);
		}
		
		return answer;
	}
}
