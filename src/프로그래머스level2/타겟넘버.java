package ���α׷��ӽ�level2;
/*
 * n���� ���� �ƴ� ����. �� ���� ������ ���ϰų� ���� Ÿ�ٳѹ��� ������ �Ѵ�.
 * ����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű�����
 * Ÿ�ٳѹ��� ����� ����� �� return�ϵ��� solution �ۼ�
 */
//DFS ������ �´µ�...
// dfs�� Ȱ���� �ش� node = �迭�� index, �� ���ڸ� + , - �� �迭�� �־��ش�
// node�� �ش� �迭���� Ž���ߴٸ�, nubmers�迭��  �� ���Ѵ�.
// target�� ���ؼ� ��ġ�ϸ� ī��Ʈ +1, �ƴϸ� �ٽ� Ž�� �� �ݺ�
public class Ÿ�ٳѹ� {
	static int answer = 0;
	public int solution(int[] numbers, int target) {
		
		// numbers for�� �����鼭 temp�� �ӽ÷� �� �����ش�
		// �̶� �����ִ� �� ���� -
		dfs(numbers, target, 0);
				
		return answer;
	}
	
	public static void dfs(int[] numbers, int target, int node) {
		if(node == numbers.length) {
			int sum = 0;
			for(int num : numbers) {
				sum += num;
			}
			if(sum == target) {
				answer++;
			}
		}else {
			numbers[node] *=1;
			dfs(numbers,target,node+1);
			
			numbers[node] *= -1;
			dfs(numbers,target, node+1);
		}
	}
}

//DFS �� stack, ����Լ��� ������ �� �ְ�,
//BFS�� queue�� ���� �����ϴ�.
