package DFS_BFS;

public class Ÿ�ٳѹ�_level2 {
	//���ڸ��� dfs�� ��� ������ �� �� �� ��Ģ��������
	//�迭�� �ִ� ��Ұ� �ϳ��� ����� �����Ѵٸ�, �迭�� �ε����� ����
	//�ᱹ�� �� ���̿� ���� ��� Ž���ϰ� �ǰ�, ��� ����� ���� ��� Ž���ϰ� �ȴ�.
	//DFS������ ��ȭ�İ� ���������� ã�� ���� �߿�. 
	//���������� ��� ����, �� �迭�� ��� ��ҿ� �������� ��.
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
	//�迭�� �ε��� = ����, �迭�� ��� = node
	public int dfs(int[] numbers, int target, int index, int num) {
		if(index == numbers.length) {//���̰� �迭�� �����̿� ���ٸ� = ������ ���̱��� �������ٸ�
			return num == target ? 1 : 0; // ���� ��� Ž���ߴµ� ���ϴ� ���� target���� ���ٸ� �װ� �ϳ��� ��� ��, �ƴ϶�� ����.
		}else {
			return dfs(numbers, target, index+1, num + numbers[index])
					+ dfs(numbers, target, index+1, num - numbers[index]);
		}
	}
}
