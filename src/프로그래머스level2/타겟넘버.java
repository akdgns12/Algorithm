package 프로그래머스level2;
/*
 * n개의 음이 아닌 정수. 이 수를 적절히 더하거나 빼서 타겟넘버를 만들어야 한다.
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수
 * 타겟넘버를 만드는 방법의 수 return하도록 solution 작성
 */
//DFS 문제는 맞는데...
// dfs를 활용해 해당 node = 배열의 index, 의 숫자를 + , - 로 배열에 넣어준다
// node가 해당 배열까지 탐색했다면, nubmers배열을  다 더한다.
// target과 비교해서 일치하면 카운트 +1, 아니면 다시 탐색 후 반복
public class 타겟넘버 {
	static int answer = 0;
	public int solution(int[] numbers, int target) {
		
		// numbers for문 돌리면서 temp에 임시로 다 더해준다
		// 이때 더해주는 것 위에 -
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

//DFS 는 stack, 재귀함수로 구현할 수 있고,
//BFS는 queue로 구현 가능하다.
