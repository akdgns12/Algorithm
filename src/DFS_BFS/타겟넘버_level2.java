package DFS_BFS;

public class 타겟넘버_level2 {
	//보자마자 dfs로 재귀 돌리면 될 듯 각 사칙연산으로
	//배열에 있는 요소가 하나의 노드라고 비유한다면, 배열의 인덱스는 깊이
	//결국은 각 깊이에 대해 모두 탐색하게 되고, 모든 경우의 수를 모두 탐색하게 된다.
	//DFS에서는 점화식과 종료조건을 찾는 것이 중요. 
	//종료조건은 모든 깊이, 즉 배열의 모든 요소에 접근했을 때.
	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0);
	}
	//배열의 인덱스 = 깊이, 배열의 요소 = node
	public int dfs(int[] numbers, int target, int index, int num) {
		if(index == numbers.length) {//깊이가 배열의 길이이와 같다면 = 마지막 깊이까지 내려갔다면
			return num == target ? 1 : 0; // 깊이 모두 탐구했는데 구하는 값이 target값과 같다면 그것 하나의 경우 뿐, 아니라면 없다.
		}else {
			return dfs(numbers, target, index+1, num + numbers[index])
					+ dfs(numbers, target, index+1, num - numbers[index]);
		}
	}
}
